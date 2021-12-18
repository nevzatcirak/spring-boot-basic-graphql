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

    public Optional<ApprovalProcess> getApproverProcess(String approver) {
        return approvalProcesses.stream().filter(process -> process.getApproverIds().stream()
                .anyMatch(id -> id.equals(approver))).findFirst();
    }

    public List<ApprovalProcess> getApproverProcesses(String approver) {
        return approvalProcesses.stream().filter(process -> process.getApproverIds().stream()
                .anyMatch(id -> id.equals(approver))).collect(Collectors.toList());
    }

    public void saveProcess(ApprovalProcess approvalProcess) {
        approvalProcesses.add(0, approvalProcess);
    }
}
