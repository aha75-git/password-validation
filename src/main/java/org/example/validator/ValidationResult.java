package org.example.validator;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
    private final List<Reason> reasons;

    public ValidationResult() {
        this.reasons = new ArrayList<>();
    }

    public void addReason(Reason reason) {
        this.reasons.add(reason);
    }

    public boolean isValid() {
        return reasons.isEmpty();
    }

    public List<Reason> getReasons() {
        return this.reasons;
    }
}
