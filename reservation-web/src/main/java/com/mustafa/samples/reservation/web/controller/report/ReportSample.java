package com.mustafa.samples.reservation.web.controller.report;

/**
 * Created by SECKİN on 22.05.2017.
 */

import com.mebitech.robe.report.ReportUtil;
import org.jfree.report.ReportProcessingException;
import org.pentaho.reporting.libraries.xmlns.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.table.TableModel;
import java.io.IOException;


/**
 * Created by SECKİN on 22.05.2017.
 */
@Service
public class ReportSample {

    @Autowired
    ReportUtil reportUtil;
    @Autowired
    SpringDemoData demoData;

    public ReportSample reportFunc() {

        String columnNames[] = new String[]{"fruit", "number", "fruit"};
        String data[][] = new String[][]{new String[]{"Apple", "One", "Apple"},
                new String[]{"aaa", "Two", "Apple"}, new String[]{"Apple", "Three", "Apple"},
                new String[]{"Oraaaange", "Four", "Orange"}, new String[]{"Orange", "Five", "Orange"},};


        demoData = new SpringDemoData(columnNames, data);
//    demoData.setColumnNames(columnNames);


        // run the demo
        try {
            reportUtil.reportPdf(demoData, "spring-demo-report-def.xml", "reportPdf");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ReportProcessingException e) {
            e.printStackTrace();
        }
        return this;

    }


}

