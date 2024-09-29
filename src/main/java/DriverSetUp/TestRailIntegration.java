package DriverSetUp;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestRailIntegration {
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

//получить инфо о всех проектах
        List<Project> projectsList = myTestRail.projects().list().execute();
        for (Project project: projectsList){
            System.out.println("Name of project:  "+ project.getName()+". "+
                    "ID of project is: " + project.getId());
        }

        //получаем все ИД проектов

        ArrayList<Integer>idOfProject = new ArrayList<>();
        for (Project project: projectsList){
            idOfProject.add(project.getId());
        }
     //вывод всех сьютов проекта
        for (int a = 0; a < idOfProject.size(); a++){
            List<Suite> suiteList = myTestRail.suites().list(idOfProject.get(a)).execute();
            for (Suite suite: suiteList){
                System.out.println("Name of suite:" + suite.getName() + ". ID of suite is  "
                        + suite.getId());
            }
        }

//вывод папок (секций)

       List<Section> sectionList = myTestRail.sections().list(1).execute();
        for (Section section: sectionList){
            System.out.println("Name of section is " + section.getName()
                    + ". ID of section is " + section.getId());
        }

        //вывод тест кейсов
        for (int i = 0; i < idOfProject.size(); i++) {
            List<CaseField> caseFieldList = myTestRail.caseFields().list().execute();
            List<Case> caseList = myTestRail.cases().list(idOfProject.get(i), caseFieldList).execute();
            for (Case testCase : caseList) {
                System.out.println("Name of testCase is " + testCase.getTitle()
                        + ". ID of testCase is " + testCase.getId());
            }

        }


        List<CaseField> caseFieldList = myTestRail.caseFields().list().execute();
        List<Case> caseList = myTestRail.cases().list(1, caseFieldList).execute();
        ArrayList<Integer> testCaseId = new ArrayList<>();
        for (Case testCase : caseList) {
            testCaseId.add(testCase.getId());
        }


        //создание тест Рана
        Run run = myTestRail.runs().add(1, new Run().setName("Name Run2 Test Lesson 12")).execute();
        List<ResultField> resultFieldList = myTestRail.resultFields().list().execute();
        StatusForTest[] statusForTests = StatusForTest.values();
        //ставим рандомные статусы на тест кейсы
        int randomStatus  = statusForTests[new Random().nextInt(statusForTests.length)].getStatusValue();
        for (Integer caseId: testCaseId){
        myTestRail.results().addForCase(run.getId(), caseId, new Result()
            .setStatusId(statusForTests[new Random().nextInt(statusForTests.length)]
                    .getStatusValue()), resultFieldList).execute();
}

        myTestRail.results().addForCase(run.getId(), 5, new Result().setStatusId(1), resultFieldList).execute();


        //тест кейсам можно ставить статусы. 1 - passed, 2 - block, 3 - untested, 4 - retest, 5 - failed
        //собрать все ИД




//закрываем тест ран
        //List<Run> runList = myTestRail.runs().list(1).execute();
        myTestRail.runs().close(run.getId()).execute();

        



    }
}
