/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.nist.fhir;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.immregistries.vfa.connect.model.ForecastEngineIssue;
import org.immregistries.vfa.connect.model.ForecastEngineIssueLevel;
import org.immregistries.vfa.connect.model.ForecastEngineIssueType;

/**
 *
 * @author mccaffrey
 */
public class TCHUtils {

    public static final String ISSUEDIVIDER = "##########";
    public static final String SUBISSUEDIVIDER = "&&&&&&&&&&";

    public static String convertIssuesToString(List<ForecastEngineIssue> issues) {
        if (issues == null) {
            return "";
        }
        StringBuilder string = new StringBuilder();
        Iterator<ForecastEngineIssue> it = issues.iterator();
        while (it.hasNext()) {

            ForecastEngineIssue issue = it.next();
            string.append(issue.getIssueLevel().toString());
            string.append(TCHUtils.SUBISSUEDIVIDER);
            string.append(issue.getIssueType().toString());
            string.append(TCHUtils.SUBISSUEDIVIDER);
            string.append(issue.getDescription());
            string.append(TCHUtils.ISSUEDIVIDER);

        }
        return string.toString();
    }

    public static List<ForecastEngineIssue> convertStringToIssues(String string) {
        if (string == null) {
            return new ArrayList<>();
        }

        List<ForecastEngineIssue> feIssues = new ArrayList<>();

        String issues[] = string.split(TCHUtils.ISSUEDIVIDER);

        System.out.println("length = " + issues.length);
        for (int i = 0; i < issues.length; i++) {
            ForecastEngineIssue issue = new ForecastEngineIssue();
            String issueString = issues[i];
            String subIssue[] = issueString.split(TCHUtils.SUBISSUEDIVIDER);
            System.out.println("length = " + subIssue.length);
            issue.setIssueLevel(ForecastEngineIssueLevel.valueOf(subIssue[0]));
            System.out.println("subissue = " + subIssue[1]);

            if (subIssue[1].startsWith("01")) {
                //issue.setIssueType(ForecastEngineIssueType.AUTHENTICATION_FAILURE);                
                issue.setIssueType(ForecastEngineIssueType.UNEXPECTED_FORMAT);
            } else if (subIssue[1].startsWith("02")) {
            //    issue.setIssueType(ForecastEngineIssueType.ENGINE_NOT_AVAILABLE);
            issue.setIssueType(ForecastEngineIssueType.UNEXPECTED_FORMAT);
            } else if (subIssue[1].startsWith("03")) {
              //  issue.setIssueType(ForecastEngineIssueType.MATCH_NOT_FOUND);
              issue.setIssueType(ForecastEngineIssueType.UNEXPECTED_FORMAT);
            } else if (subIssue[1].startsWith("04")) {
                issue.setIssueType(ForecastEngineIssueType.UNEXPECTED_FORMAT);
            } else {
                issue.setIssueType(ForecastEngineIssueType.UNEXPECTED_FORMAT);
            }

            issue.setDescription(subIssue[2]);
            feIssues.add(issue);
        }

        return feIssues;

    }

}
