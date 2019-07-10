package com.onsolve.exercise.pages;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.onsolve.exercise.common.Helper;
import com.onsolve.exercise.model.LeadFormDTO;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringReader;

public class CaptureForm extends AbstractPage {

    private static final String ID_FIRST_NAME = "RESULT_TextField-1";
    private static final String ID_LAST_NAME = "RESULT_TextField-2";
    private static final String ID_STREET_ADDRESS = "RESULT_TextField-3";
    private static final String ID_ADDRESS_LINE2 = "RESULT_TextField-4";
    private static final String ID_CITY = "RESULT_TextField-5";
    private static final String ID_STATE = "RESULT_RadioButton-6";
    private static final String ID_ZIP_CODE = "RESULT_TextField-7";
    private static final String ID_PHONE_NUMBER = "RESULT_TextField-8";
    private static final String ID_EMAIL_ADDRESS = "RESULT_TextField-9";
    private static final String XPATH_CALENDAR = "//*[@alt='calendar']";
    private static final String CSS_CURRENT_DATE = "td.ui-datepicker-days-cell-over.ui-datepicker-today";
    private static final String ID_SUBMIT_BTN = "FSsubmit";
    private static final String ID_PASSWORD = "Password";
    private static final String XPATH_SUBMIT_PASSWORD = "//*[@class='submit_button']";

    @FindBy(id = ID_PASSWORD)
    private WebElement textInputPassword;

    @FindBy(id = ID_FIRST_NAME)
    private WebElement textInputFirstName;

    @FindBy(id = ID_LAST_NAME)
    private WebElement textInputLastName;

    @FindBy(id = ID_STREET_ADDRESS)
    private WebElement textInputStreetAddress;

    @FindBy(id = ID_ADDRESS_LINE2)
    private WebElement textInputAddressLine2;

    @FindBy(id = ID_CITY)
    private WebElement textInputCity;

    @FindBy(id = ID_STATE)
    private WebElement selectState;

    @FindBy(id = ID_ZIP_CODE)
    private WebElement textInputZipCode;

    @FindBy(id = ID_PHONE_NUMBER)
    private WebElement textInputPhoneNumber;

    @FindBy(id = ID_EMAIL_ADDRESS)
    private WebElement textInputEmail;

    @FindBy(xpath = XPATH_CALENDAR)
    private WebElement btnCalendar;

    @FindBy(css = CSS_CURRENT_DATE)
    private WebElement currentDate;

    @FindBy(id = ID_SUBMIT_BTN)
    private WebElement btnSubmit;

    @FindBy(xpath = XPATH_SUBMIT_PASSWORD)
    private WebElement btnSubmitPassword;


    public void openPage() {
        driver.get(yamlConfig.getLeadFormURL());
    }

    public void inputDefaultPassword() {
        textInputPassword.sendKeys("secret");
    }

    public void fillTheLeadForm(LeadFormDTO leadFormDTO) {
        textInputFirstName.sendKeys(leadFormDTO.getFirstName());
        textInputLastName.sendKeys(leadFormDTO.getLastName());
        textInputStreetAddress.sendKeys(leadFormDTO.getStreetAddress());
        textInputAddressLine2.sendKeys(leadFormDTO.getAddressLine2());
        textInputCity.sendKeys(leadFormDTO.getCity());

        Select state = new Select(selectState);
        state.selectByVisibleText(leadFormDTO.getState());

        textInputZipCode.sendKeys(leadFormDTO.getZipCode());
        textInputPhoneNumber.sendKeys(leadFormDTO.getPhoneNumber());
        textInputEmail.sendKeys(leadFormDTO.getEmail());

        btnCalendar.click();
        currentDate.click();
    }

    public void submitPassword() {
        btnSubmitPassword.click();
    }

    public void submit() {
        btnSubmit.click();
    }

    public boolean isResultSubmitSuccessful(LeadFormDTO leadFormDTO) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException, UnirestException {
        String resultXML = Helper.queryResultsList();

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;

        dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(new InputSource(new StringReader(resultXML)));
        doc.getDocumentElement().normalize();

        XPath xPath = XPathFactory.newInstance().newXPath();

        String resultExpression = "/fs_response/results/result";
        NodeList nodeList = (NodeList) xPath.compile(resultExpression).evaluate(
                doc, XPathConstants.NODESET);

        String resultId;

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                NodeList valueList = eElement.getElementsByTagName("value");

                for (int j = 0; j < valueList.getLength(); j++) {
                    String value = valueList.item(j).getTextContent();
                    if (value.equals(leadFormDTO.getFirstName())) {
                        resultId = eElement.getAttribute("id");
                        System.out.println("The form has been submit successfully, Result no :" + resultId);
                        leadFormDTO.setFormId(resultId);
                        return true;
                    }
                }
            }
        }

        System.out.println("No result found");
        return false;
    }
}
