/*
 * WorkerGeneratorURLFuzz.java
 *
 * Created on 11 November 2005, 20:33
 *
 * Copyright 2007 James Fisher
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301 USA
 */

package com.sittinglittleduck.DirBuster.workGenerators;

import com.sittinglittleduck.DirBuster.BaseCase;
import com.sittinglittleduck.DirBuster.GenBaseCase;
import com.sittinglittleduck.DirBuster.Manager;
import com.sittinglittleduck.DirBuster.WorkUnit;
import com.sittinglittleduck.DirBuster.utils.HeadRequestCheck;
import org.apache.commons.httpclient.HttpClient;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Produces the work to be done, when we are reading from a list
 */
public class WorkerGeneratorURLFuzz implements Runnable {

    HttpClient httpclient;
    private Manager manager;
    private BlockingQueue<WorkUnit> workQueue;
    private String inputFile;
    private String firstPart;
    private boolean stopMe = false;
    private boolean isWorking = true;

    private String urlFuzzStart;
    private String urlFuzzEnd;
    private int counter = 0;

    /**
     * Creates a new instance of WorkerGenerator
     *
     * @param manager Manager object
     */
    public WorkerGeneratorURLFuzz() {
        manager = Manager.getInstance();
        workQueue = manager.workQueue;
        inputFile = manager.getInputFile();
        firstPart = manager.getFirstPartOfURL();

        httpclient = manager.getHttpclient();

        urlFuzzStart = manager.getUrlFuzzStart();
        urlFuzzEnd = manager.getUrlFuzzEnd();
    }

    /**
     * Thread run method
     */
    public void run() {

        /*
         * Read in all the items and create all the work we need to.
         */


        BufferedReader d = null;
        try {
            manager.setURLFuzzGenFinished(false);
            String line;

            //int passTotal = 0;

            //Utils.getNumberOfLineInAFile(inputFile);

            HeadRequestCheck.test(firstPart);

            d = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
            System.out.println("Starting fuzz on " + firstPart + urlFuzzStart + "{dir}" + urlFuzzEnd);
            manager.setStatus("Starting fuzz on " + firstPart + urlFuzzStart + "{dir}" + urlFuzzEnd);

            BaseCase baseCaseObj = GenBaseCase.genURLFuzzBaseCase(firstPart + urlFuzzStart, urlFuzzEnd);


            while ((line = d.readLine()) != null) {
                if (stopMe) {
                    isWorking = false;
                    return;
                }

                if (!line.startsWith("#")) {
                    String method;
                    if (manager.getAuto() && !baseCaseObj.useContentAnalysisMode() && !baseCaseObj.isUseRegexInstead()) {
                        method = "HEAD";
                    } else {
                        method = "GET";
                    }

                    //url encode all the items
                    line = URLEncoder.encode(line);

                    URL currentURL = new URL(firstPart + urlFuzzStart + line + urlFuzzEnd);

                    workQueue.put(new WorkUnit(currentURL, true, method, baseCaseObj, line));
                    counter++;
                }

                //Thread.sleep(3);

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(WorkerGeneratorURLFuzz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(WorkerGeneratorURLFuzz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WorkerGeneratorURLFuzz.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                d.close();
                manager.setURLFuzzGenFinished(true);
            } catch (IOException ex) {
                Logger.getLogger(WorkerGeneratorURLFuzz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        isWorking = false;
    }

    /**
     * Method to stop the manager while it is working
     */
    public void stopMe() {
        stopMe = true;
    }

    public String getStartPoint() {
        return urlFuzzStart + "{dir}" + urlFuzzEnd;
    }

    public int getCurrentCount() {
        return counter;
    }

    public boolean isWorking() {
        return isWorking;
    }
}