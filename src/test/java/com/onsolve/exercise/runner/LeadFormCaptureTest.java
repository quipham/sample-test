package com.onsolve.exercise.runner;

import com.aventstack.extentreports.Status;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.onsolve.exercise.model.LeadFormDTO;
import com.onsolve.exercise.hooks.AbstractTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LeadFormCaptureTest extends AbstractTest {

    @Test
    public void submitLeadFormSuccessfully() throws ParserConfigurationException, UnirestException, SAXException, XPathExpressionException, IOException {
        LeadFormDTO leadFormDTO = new LeadFormDTO();
        extentTest.info("Submit new Form with First Name: " + leadFormDTO.getFirstName());
        captureForm.openPage();
        captureForm.inputDefaultPassword();
        captureForm.submitPassword();
        captureForm.fillTheLeadForm(leadFormDTO);
        captureForm.submit();
        assertTrue(captureForm.isResultSubmitSuccessful(leadFormDTO));
        extentTest.log(Status.PASS, "New Form has been submit - Form ID: " + leadFormDTO.getFormId());
    }

}
