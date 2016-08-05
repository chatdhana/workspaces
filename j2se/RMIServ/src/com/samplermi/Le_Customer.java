
package com.samplermi;

import java.io.File;
import java.util.Map;

import noNamespace.AtlasMessageDocument;
import noNamespace.AtlasMessageDocument.AtlasMessage;
import noNamespace.AtlasMessageDocument.AtlasMessage.Header;

public class Le_Customer {

	/**
	 * @param args
	 */
	// static Map<String, String> msgMap=null;
	public static void main_1() {//String[] args) {
		// TODO Auto-generated method stub
		// msgMap=msgMapInput;
		AtlasMessageDocument writexml = AtlasMessageDocument.Factory
				.newInstance();
		AtlasMessage msgOb = writexml.addNewAtlasMessage();

		headerMsgGeneration(msgOb);
		/*
		 * leIDheaderGenerate(msgOb); leInfoGenerate(msgOb);
		 * leSysConGenerate(msgOb); leTcidCodeGenerate(msgOb);
		 * leAddressGenerate(msgOb); counterpartxGenerate(msgOb);
		 * armLeCrfGenerate(msgOb); leBranchDetGenerate(msgOb);
		 */generateXmlFile(writexml);

	}

	private static void headerMsgGeneration(AtlasMessage msgOb) {
		try {
			System.out.println("Inside Header Message Generation block");
			Header hdr = msgOb.addNewHeader();
			/*
			 * hdr.setMessageId(msgMap.get("messageId"));
			 * hdr.setAction(msgMap.get("action"));
			 * hdr.setSourceSystem(msgMap.get("sourceSystem"));
			 * hdr.setEnvironment(msgMap.get("environment"));
			 * hdr.setMessageType(msgMap.get("messageType"));
			 */

			hdr.setMessageId("400531822");
			hdr.setAction("U");
			hdr.setSourceSystem("ATLAS");
			hdr.setEnvironment("london");
			hdr.setMessageType("LE_GM_ALL");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Header MessageGeneration :" + e.getMessage());
		}

	}

	/*
	 * private static void leIDheaderGenerate(AtlasMessage msgOb) { try {
	 * System.out.println("inside LE ID header Generation started..");
	 * msgOb.setLeId("400088717"); System.out.println("inside LE ID header
	 * Generation complete "); } catch(Exception e) { e.printStackTrace();
	 * System.out.println("Inside LE ID Header generation - Catch block.. "); } }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * private static void leInfoGenerate(AtlasMessage msgOb) { try {
	 * System.out.println("inside LE info Generation started.. :");
	 * 
	 * 
	 * 
	 * LeInfo leinfob = msgOb.addNewLeInfo();
	 * 
	 * leinfob.setUltParentLeId("400088717");
	 * leinfob.setParentLeId("400088717"); leinfob.setDomicileCntry("RU");
	 * leinfob.setUltRiskCntry("RU"); leinfob.setUltRiskCntryDesc("RUSSIAN
	 * FEDERATION"); leinfob.setAtlasCode("PROBUSINESSBANK*MOW");
	 * leinfob.setLeName("PROBUSINESSBANK MOW");
	 * leinfob.setLeLegalName("PROBUSINESSBANK");
	 * leinfob.setLeLegalName1("null"); leinfob.setLeStatusCode("ACTIVE");
	 * leinfob.setLeStatusCodeDesc("Active"); leinfob.setFinInstType("BANK");
	 * leinfob.setFinInstTypeDesc("Unknown"); leinfob.setLeClassCode("BK");
	 * leinfob.setLeClassCodeDesc("BANKS"); leinfob.setScbLeInd("N");
	 * leinfob.setHierarchyType("GRPHEAD"); leinfob.setHierarchyTypeDesc("Group
	 * Head"); leinfob.setIsicCode("8123"); leinfob.setIsicCodeDesc("COMMERCIAL
	 * BANKS - FOREIGN"); leinfob.setInstSector("320");
	 * leinfob.setInstSectorDesc("Other Incorporated Companies");
	 * leinfob.setLeLangCode("ENGLISH"); leinfob.setLeLangCodeDesc("English");
	 * leinfob.setDataProtInd("N"); leinfob.setNorDeclInd("N");
	 * leinfob.setTrdInd("Y"); leinfob.setGlbLimitInd("GLBLMT");
	 * leinfob.setBrokerId("null"); leinfob.setDisclosureAgrInd("N");
	 * leinfob.setDocComplInd("N"); leinfob.setDocComplDate("");
	 * leinfob.setLeNote("null"); leinfob.setConfReqInd("N");
	 * leinfob.setScbCreditGrade("6B"); leinfob.setScbCreditGradeDesc("6B");
	 * leinfob.setTopBankInd("N"); leinfob.setLeType("BANK");
	 * leinfob.setLeTypeDesc("BANK test"); leinfob.setEuroCompInd("Y");
	 * leinfob.setActivateInd("Y"); leinfob.setClsEigibility("N");
	 * leinfob.setClsCustType("null"); leinfob.setClsStartDate("");
	 * leinfob.setGroupCoType("99"); leinfob.setCruser("gsenthil");
	 * leinfob.setCrdate("2009-06-25T05:38:07:0Z"); leinfob.setUpcount("3");
	 * leinfob.setUpdstatus("U"); leinfob.setUpddate("2009-06-25T05:38:07:0Z");
	 * leinfob.setUpduser("geetha"); leinfob.setVerified("T");
	 * leinfob.setVerifieduser("kjacob");
	 * leinfob.setVerifydate("2009-06-25T05:38:07:0Z");
	 * leinfob.setBisWeighting("100");
	 * leinfob.setDisclAgrDate("2009-06-25T05:38:07:0Z");
	 * leinfob.setDvpCustIndicator("0"); leinfob.setOpicsClassCode("999");
	 * System.out.println("LE Info Message Block Complete..."); }
	 * catch(Exception e) { e.printStackTrace(); System.out.println("LE Info
	 * catch Block - Message Generation :"+e.getMessage()); } } private static
	 * void leSysConGenerate(AtlasMessage msgOb) { try {
	 * System.out.println("Inside Le Syscontact block -- Message generation");
	 * LeSysContact lesyscont = msgOb.addNewLeSysContact();
	 * lesyscont.setMediumCode("SWIFT"); lesyscont.setMediumCodeDesc("SWIFT
	 * CODE"); lesyscont.setMediumUsage("MAIN");
	 * lesyscont.setMediumUsageDesc("Main");
	 * lesyscont.setAddrLine("PRBMRUMMXXXXXXXX");
	 * lesyscont.setLeSysConId("23867"); lesyscont.setConfirmationText("null");
	 * lesyscont.setDescription("null"); lesyscont.setUpdstatus("N");
	 * lesyscont.setVerified("Y"); System.out.println("LE sys contact block
	 * complete -- Message Generation.."); } catch(Exception e) {
	 * e.printStackTrace(); System.out.println("LE sys contact catch block --
	 * Message Generation.."+e.getMessage()); } }
	 * 
	 * private static void leTcidCodeGenerate(AtlasMessage msgOb) { try {
	 * System.out.println("LE Tcid code block started -- Message Generation..");
	 * LeTcId leTcidOb = msgOb.addNewLeTcId();
	 * 
	 * leTcidOb.setTcIdCode("PROB"); leTcidOb.setStatus("ACTIVE");
	 * leTcidOb.setStatusDesc("Active"); leTcidOb.setUpdstatus("N");
	 * leTcidOb.setVerified("Y");
	 * 
	 * System.out.println("LE Tcid code block complete -- Message
	 * Generation.."); } catch(Exception e) { e.printStackTrace();
	 * System.out.println("Le Tcid code catch block... - Message
	 * Generation.."+e.getMessage()); } }
	 * 
	 * private static void leAddressGenerate(AtlasMessage msgOb) { try {
	 * System.out.println("LE Address code block started..");
	 * 
	 * LeAddress leAddrOb = msgOb.addNewLeAddress();
	 * 
	 * leAddrOb.setLeAddrId("614141"); leAddrOb.setAddrType("CONF");
	 * leAddrOb.setAddrTypeDesc("Confirmation");
	 * leAddrOb.setStartDate("2009-09-14 00:00:00.0");
	 * leAddrOb.setCountryIsoCode("RU"); leAddrOb.setCountryName("RUSSIAN
	 * FEDERATION"); leAddrOb.setCityCode("VOK");
	 * leAddrOb.setCityName("VLADIVOSTOK"); leAddrOb.setAddrLine1("1 NEVER
	 * STREET"); leAddrOb.setAddrLine2("null"); leAddrOb.setPostCode("null");
	 * leAddrOb.setState("null"); leAddrOb.setContRole("null");
	 * leAddrOb.setAltName("null"); leAddrOb.setTitle("null");
	 * leAddrOb.setContFirstName("null"); leAddrOb.setContLastName("null");
	 * leAddrOb.setContFax("null"); leAddrOb.setContEmail("null");
	 * leAddrOb.setContPhone("null"); leAddrOb.setContTelex("null");
	 * leAddrOb.setDescription("null"); leAddrOb.setUpdstatus("I");
	 * leAddrOb.setVerified("T");
	 * 
	 * System.out.println("LE Address Code Complete....");
	 *  } catch(Exception e) { e.printStackTrace(); System.out.println("Le
	 * Address Code catch block... pl check.."+e.getMessage()); } }
	 * 
	 * private static void leAltAdrGenerate(AtlasMessage msgOb) { try {
	 * System.out.println("LE Alt Address Code - Started..");
	 * 
	 * LeAltAddress leAltadob = msgOb.addNewLeAltAddress();
	 * 
	 * System.out.println("LE Alt Address Info...Code - Started..");
	 * LeAltAddressInfo leAltInfo = leAltadob.addNewLeAltAddressInfo();
	 * 
	 * leAltInfo.setLeAddrId("614141"); leAltInfo.setScbLeId("300010872");
	 * leAltInfo.setProduct("FXD"); leAltInfo.setProductType("FX");
	 * leAltInfo.setUpdstatus("I"); leAltInfo.setVerified("T");
	 * System.out.println("LE Alt Address Info...Code - Started..");
	 * System.out.println("LE Alt Address Code message part..- Complete.."); }
	 * catch(Exception e) { e.printStackTrace(); System.out.println("LE Alt
	 * Address Catch block...pl check..."+e.getMessage()); } } private static
	 * void counterpartxGenerate(AtlasMessage msgOb) { try {
	 * System.out.println("Counterparty xref message generation started");
	 * 
	 * CounterpartyXref cpXfOb = msgOb.addNewCounterpartyXref();
	 * 
	 * cpXfOb.setPartyXrefCode("PROBUSINESSBANK*MOW");
	 * cpXfOb.setLocationCode("FRA"); cpXfOb.setExtrnlSystmCode("FEDS");
	 * cpXfOb.setImmsMnemonic("null"); cpXfOb.setUpcount("1");
	 * cpXfOb.setUpdstatus("I"); cpXfOb.setVerified("T");
	 * 
	 * System.out.println("Counterparty xref message generation Complete"); }
	 * catch(Exception e) { e.printStackTrace();
	 * System.out.println("Counterparty xref catch block...."+e.getMessage()); } }
	 * 
	 * private static void armLeCrfGenerate(AtlasMessage msgOb) { try {
	 * System.out.println("Arm Le Crf Generation -- started.");
	 * 
	 * ArmLeCrf armLeCfOb = msgOb.addNewArmLeCrf();
	 * 
	 * armLeCfOb.setArmCrfId("113935"); armLeCfOb.setArmCode("XXX");
	 * armLeCfOb.setArmCrfStatus("A"); armLeCfOb.setUpdstatus("N");
	 * armLeCfOb.setVerified("Y");
	 * 
	 * System.out.println("Arm Le Crf Generation -- complete"); }
	 * catch(Exception e) { e.printStackTrace(); System.out.println("Inside Arm
	 * LE crf catch block...."+e.getMessage()); } }
	 * 
	 * private static void leBranchDetGenerate(AtlasMessage msgOb) { try {
	 * System.out.println("leBranch Details Generate - started ");
	 * LeBranchDetails lbrdetOb = msgOb.addNewLeBranchDetails(); LeBranchInfo
	 * lbrInfOb= lbrdetOb.addNewLeBranchInfo(); lbrInfOb.setScbLeId("10075222");
	 * lbrInfOb.setCustStatRsnCode("null"); lbrInfOb.setCustStatChngDt("null");
	 * lbrInfOb.setPhoneConfirm("N"); lbrInfOb.setNetSettle("NO");
	 * lbrInfOb.setNovation("NONE"); lbrInfOb.setManualSettle("N");
	 * lbrInfOb.setPhoneNumber("null"); lbrInfOb.setFaxNumber("null");
	 * lbrInfOb.setArmCode("XXX"); lbrInfOb.setCustStatus("OPEN");
	 * lbrInfOb.setUpdstatus("I"); lbrInfOb.setVerified("T");
	 * System.out.println("leBranch Details Generate - Complete ");
	 *  } catch(Exception e) { e.printStackTrace(); System.out.println("Inside
	 * leBranch Details -- Catch Block.. "+e.getMessage()); } }
	 */
	private static void generateXmlFile(AtlasMessageDocument writexml) {
		try {
			System.out.println("inside generateXmlFile :");

			// String filepath ="C:/Documents and
			// Settings/1333216/Desktop/country.xml";
			String filepath = "C:/dhana/le_v0.3.xml";
			File file = new File(filepath);
			writexml.save(file);
			System.out.println("File Generated successfully :");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("generateXmlFile :" + e.getMessage());
		}

	}
}
