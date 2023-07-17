package cn.edu.tju.domain;

public class UploadInfo {
    private int index;
    private String fileName;
    public String description;
    public String instruction;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    @Override
    public String toString() {
        return "UploadInfo{" +
                "index=" + index +
                ", fileName='" + fileName + '\'' +
                ", description='" + description + '\'' +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}
