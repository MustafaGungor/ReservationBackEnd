package com.mustafa.samples.reservation.web.controller.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by SECKİN on 22.05.2017.
 */
@RestController
@RequestMapping(value = "reports")
@Transactional
public class ReportController {


    @Autowired
    ReportSample reportSample;

    @RequestMapping(method = RequestMethod.GET)
    public ReportSample reportDeneme(){
       return reportSample.reportFunc();
    }


}
