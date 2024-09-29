package utils;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.*;

import java.util.ArrayList;
import java.util.List;

public class TestRailIntegrationFinalProject {
    public enum StatusForTest{
        PASSED(1), BLOCKED(2), RETEST(4), FAILED(5);

        private int statusValue;

        public int getStatusValue() {
            return statusValue;
        }

        StatusForTest(int statusValue) {
            this.statusValue = statusValue;
        }
    }
    public static void main(String[] args) {
        //получаем екземпляр TestRail
        String testRailUrl = "https://lidiyagyuva.testrail.io/";
        String userName = "Lidiya@gmail.com";
        String password = "9999@tAmArA";

        TestRail myTestRail = TestRail.builder(testRailUrl, userName, password)
                .applicationName("TestRailIntegration").build();

//ВИВОД ФІНАЛЬНОГО ПРОЕКТА
//вывод папок (секций)
       List<Section> sectionList = myTestRail.sections().list(2).execute();
        for (Section section: sectionList){
            System.out.println("Name of section is " + section.getName()
                    + ". ID of section is " + section.getId());
        }

        //вывод тест кейсов
        List<CaseField> caseFieldList = myTestRail.caseFields().list().execute();
        List<Case> caseList = myTestRail.cases().list(2, caseFieldList).execute();
        ArrayList<Integer> testCaseId = new ArrayList<>();
        for (Case testCase : caseList) {
            testCaseId.add(testCase.getId());
            System.out.println("Name of testCase is " + testCase.getTitle()
                    + ". ID of testCase is " + testCase.getId());
        }


        //создание тест Рана
        Run run = myTestRail.runs().add(2, new Run().setName("TestRun Final Project")).execute();
        List<ResultField> resultFieldList = myTestRail.resultFields().list().execute();
        StatusForTest[] statusForTests = StatusForTest.values();

        myTestRail.results().addForCase(run.getId(), 44, new Result().setStatusId(1), resultFieldList).execute();
        myTestRail.results().addForCase(run.getId(), 49, new Result().setStatusId(1), resultFieldList).execute();
        myTestRail.results().addForCase(run.getId(), 50, new Result().setStatusId(1), resultFieldList).execute();
        myTestRail.results().addForCase(run.getId(), 51, new Result().setStatusId(1), resultFieldList).execute();
        myTestRail.results().addForCase(run.getId(), 52, new Result().setStatusId(4), resultFieldList).execute();
        myTestRail.results().addForCase(run.getId(), 53, new Result().setStatusId(4), resultFieldList).execute();
        myTestRail.results().addForCase(run.getId(), 45, new Result().setStatusId(4), resultFieldList).execute();
        myTestRail.results().addForCase(run.getId(), 46, new Result().setStatusId(4), resultFieldList).execute();
        myTestRail.results().addForCase(run.getId(), 47, new Result().setStatusId(1), resultFieldList).execute();
        myTestRail.results().addForCase(run.getId(), 48, new Result().setStatusId(1), resultFieldList).execute();
        myTestRail.results().addForCase(run.getId(), 58, new Result().setStatusId(1), resultFieldList).execute();
        myTestRail.results().addForCase(run.getId(), 57, new Result().setStatusId(1), resultFieldList).execute();
        myTestRail.results().addForCase(run.getId(), 56, new Result().setStatusId(1), resultFieldList).execute();
        myTestRail.results().addForCase(run.getId(), 55, new Result().setStatusId(4), resultFieldList).execute();
        myTestRail.results().addForCase(run.getId(), 54, new Result().setStatusId(1), resultFieldList).execute();

//закрываем тест ран
        //List<Run> runList = myTestRail.runs().list(1).execute();
        //myTestRail.runs().close(run.getId()).execute();

    }
}
