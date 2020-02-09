package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HIS {
    public String assessmentDate;
    public String dateAssessorSigned;
    public String status;
    public String assessmentType;
    public String dwellingType;
    public String familyLivingOn;
    public String accessibilityConcerns;
    public String numberofBedrooms;
    public String stairsRequiredoConsumerBedroom;
    public String numberofBathrooms;
    public String stairsRequiredtoConsumerBathroom;
    public String homeDescriptionComments;
    public String accessibilityConcernsExplained;
    public String homeMeaningComments;
    public String homeStoryComments;
    public String homeStabilityComments;
}
