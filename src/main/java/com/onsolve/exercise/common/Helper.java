package com.onsolve.exercise.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.onsolve.exercise.model.YAMLConfig;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class Helper {
    private static YAMLConfig yamlConfig;

    public static void setYamlConfig(YAMLConfig yamlConfig) {
        Helper.yamlConfig = yamlConfig;
    }

    public static YAMLConfig getYamlConfig() {
        return yamlConfig;
    }

    public static String generateRandomNumber() {
        Random random = new Random();
        return String.format("%08d", random.nextInt(99999999));
    }

    public static String getCurrentTime() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("MM:dd-HH:mm:ss");
        return dateFormat.format(date);
    }

    public static String getRootDir() {
        return System.getProperty("user.dir");
    }

    public static String getResourceDir() {
        return System.getProperty("user.dir") + "/src/main/resources/";
    }

    public static <T> T yamlToObject(Class<T> clazz, String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(new File(filePath), clazz);
    }

    public static String queryResultsList() throws UnirestException {
        HttpResponse<String> response;
        response = Unirest.get("https://fs28.formsite.com/api/users/ecnvietnam/forms/form1/results")
                .queryString("fs_api_key", "Qm8nO3h6auh7")
                .asString();
        assertEquals(response.getStatus(), 200);
        return response.getBody();
    }

    private Helper() {
    }
}
