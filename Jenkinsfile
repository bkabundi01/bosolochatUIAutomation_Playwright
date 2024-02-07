pipeline {
    agent any

    stages {
        stage('GitHub Updated') {
            steps {
                echo 'Automation Script in Repository Has Been Updated!!'
            }
        }

        stage("Regression Automation Test") {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/bkabundi01/bosolochatUIAutomation_Playwright'
                    sh "mvn clean test -Dsurefire.suiteXmlFiles = src/test/resources/TestSuites/testng_regression.xml"
                }
            }
        }

        stage("Publish Extent Report") {
            steps {
                publishHTML([allowMissing: false,
                alwaysLinkToLastBuild: false,
                keepAll: true,
                reportDir: 'src/test/resources/Reports',
                reportFiles: 'TestExecutionReport.html',
                reportName: 'HTML Extent Report',
                reportTitles: ''])
            }
        }

    }
}