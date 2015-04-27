package services

import factory.TextFactory
import factory.XMLFactory

class GenerateBookReportService {

    public static final String XML = "XML format report", TXT = "Text format report"
    def report

    def generateReport(String type) {
        switch (type) {
            case XML:
                report = XMLFactory.build()
                report.createReportFile()
                break;
            case TXT:
                report = TextFactory.build()
                report.createReportFile()
                break;
            default: println "nothing,you are"
        }
    }
}
