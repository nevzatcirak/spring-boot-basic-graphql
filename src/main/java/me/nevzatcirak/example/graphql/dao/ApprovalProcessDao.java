package me.nevzatcirak.example.graphql.dao;

import me.nevzatcirak.example.graphql.model.ApprovalProcess;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ApprovalProcessDao {
    private List<ApprovalProcess> approvalProcesses;

    public ApprovalProcessDao(List<ApprovalProcess> approvalProcesses) {
        this.approvalProcesses = approvalProcesses;
    }

    public List<ApprovalProcess> getRecentProcess(int count, int offset) {
        return approvalProcesses.stream().skip(offset).limit(count).collect(Collectors.toList());
    }

    public List<ApprovalProcess> getApproverProcesses(String processId) {
        return approvalProcesses.stream().filter(process -> process.getId().equals(processId)).collect(Collectors.toList());
    }

    public ApprovalProcess getApproverProcess(String processId) {
        return approvalProcesses.stream().filter(process -> process.getId().equals(processId)).findFirst().get();
    }

    public ApprovalProcess saveProcess(ApprovalProcess approvalProcess) {
        approvalProcesses.add(0, approvalProcess);
        return approvalProcess;
    }
}
