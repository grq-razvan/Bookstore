package models

class TextReport extends AbstractReport {

    private List<String> rows

    TextReport() {
        rows = new ArrayList<>()
    }


    void addData(String data) {
        rows.add(data)
    }

    void createReportFile() {
        File output = new File("resources/" + this.getClass().getSimpleName() + "-" + this.hashCode() + ".txt")
        PrintWriter writer = new PrintWriter(output)
        if (rows.size() == 0) {
            writer.println("No books with no copies")
        }
        for (String data in rows) {
            writer.println(data)
        }
        writer.close()
    }
}
