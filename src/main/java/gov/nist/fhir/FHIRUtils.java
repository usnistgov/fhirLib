/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.nist.fhir;

import java.util.UUID;
import org.hl7.fhir.dstu3.model.Coding;

/**
 *
 * @author mccaffrey
 */
public class FHIRUtils {
    
    
	//public final static Id FHIR_VERSION = createFHIRVersion();

	public enum AGGREGATION {
		CONTAINED("contained"), REFERENCED("referenced"), BUNDLED("bundled");

		public final java.lang.String code;

		AGGREGATION(java.lang.String code) {
			this.code = code;
		}
	}
/*
	public enum FORMAT {
		JSON("json"), XML("xml");

		public final Code code;

		FORMAT(java.lang.String code) {
			this.code = FhirFactory.eINSTANCE.createCode();
			this.code.setId(createId().getValue());
			this.code.setValue(code);
		}
	}
*/
        /*
	public enum CONFORMANCE_STATUS {
		DRAFT("draft"), ACTIVE("active"), RETIRED("retired");

		public final Code code;

		CONFORMANCE_STATUS(java.lang.String code) {
			this.code = FhirFactory.eINSTANCE.createCode();
			this.code.setId(createId().getValue());
			this.code.setValue(code);
		}
	}
	*/
        
	public enum IMMUNIZATION_STATUS {
		IN_PROGRESS("in-progress", 	"In Progress"), ON_HOLD("on-hold","On Hold"), COMPLETED("completed", "Completed"), ENTERED_IN_ERROR("entered-in-error", "Entered in Error"), STOPPED("stopped", "Stopped");

		public final Coding coding;

		IMMUNIZATION_STATUS(java.lang.String s, java.lang.String display) {
			this.coding = new Coding();
			//Code code = FhirFactory.eINSTANCE.createCode();
			coding.setId(UUID.randomUUID().toString());
			coding.setCode(s);                        
			coding.setSystem("http://hl7.org/fhir/immunization-status");			
			coding.setDisplay(display);
		}
	}

	public enum IMMUNIZATION_RECOMMENDATION_STATUS {
		DUE("due"), OVERDUE("overdue");

		public final Coding coding;

		IMMUNIZATION_RECOMMENDATION_STATUS(java.lang.String s) {
			this.coding = new Coding();			
			coding.setId(UUID.randomUUID().toString());
			coding.setCode(s);			
		}
	}
	
	public enum IMMUNIZATION_RECOMMENDATION_DATE_CRITERION {
		DUE("due", "Due Date"), RECOMMENDED("reommended","Recommended Date"), EARLIEST("earliest", "Earliest Date"), OVERDUE("overdue", "Past Due Date"), LATEST("latest", "Latest Date");

		public final Coding coding;

		IMMUNIZATION_RECOMMENDATION_DATE_CRITERION(java.lang.String s, java.lang.String display) {
			this.coding = new Coding();			
			coding.setId(UUID.randomUUID().toString());
			coding.setCode(s);
			coding.setSystem("http://hl7.org/fhir/immunization-recommendation-date-criterion");			
			coding.setDisplay(display);
		}
	}
/*
	public enum BOOLEAN {

		TRUE(true), FALSE(false);

		public final org.hl7.fhir.Boolean bool;

		BOOLEAN(java.lang.Boolean bool) {
			this.bool = FhirFactory.eINSTANCE.createBoolean();
			this.bool.setValue(bool);
		}
	}
*/
    
    
}
