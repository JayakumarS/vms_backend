package com.vms.crew.crewVesselAssignment;

public class CrewVesselAssignmentQueryUtil {

	public static final String getvessel = "select vessel_type_code as id ,vessel_type_name as text  from vessel_type";
	public static final String getrank = "select rank_code as id ,rank_name as text  from rank_master";

}
