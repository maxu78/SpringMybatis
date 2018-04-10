package com.mx.spring.aop.request;

public class LogRequest {

    private String taskId;
    private String tableName;
    private String detail;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LogRequest{");
        sb.append("taskId='").append(taskId).append('\'');
        sb.append(", tableName='").append(tableName).append('\'');
        sb.append(", detail='").append(detail).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
