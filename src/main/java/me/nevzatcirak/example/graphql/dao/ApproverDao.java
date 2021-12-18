package me.nevzatcirak.example.graphql.dao;

import me.nevzatcirak.example.graphql.model.Approver;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ApproverDao {
    private List<Approver> approvers;

    public ApproverDao(List<Approver> approvers) {
        this.approvers = approvers;
    }

    public Optional<Approver> getApprover(String id) {
        return approvers.stream().filter(approver -> id.equals(approver.getId())).findFirst();
    }

    public List<Approver> getApprovers(String processId) {
        return approvers.stream().filter(approver -> approver.getProcessId().equals(processId)).collect(Collectors.toList());
    }
}
