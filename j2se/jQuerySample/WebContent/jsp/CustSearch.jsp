<!-- ************************ Document Information***************
Document Name		:    Customer Search Content JSP
Function		:    It includes all the content for Customer Search 			     
Author Name		:    TATA CONSULTANCY SERVICES
Version Number		:    1.0
Date of Creation	:    9-Sep-03
************************************************************-->
<!-- ***********************Amendment History********************
Amendment Reference	:                                       
Author Name        	:                                       
Amendment Date     	:                                       
Description of Change	:                                     
***********************Amendment History********************-->
<%@ page language="java"%>
<%--	
<!-- Instant Search Changes -->
<script type="text/javascript" language="javascript"
	src="${pageContext.request.contextPath}/jsp/js/sciInstantSearch.js"></script>
	
<script type="text/javascript">
 
	$(document).ready(function() {
		var paramOptions = {
		instantSearchURL: '${pageContext.request.contextPath}/InstantSearchHandler.do?Action=List'
							/*suggestionsHolderDivId: '',
							formName: '',
							fieldName:''*/
							};
	
		//Fields for which Instant Search is enabled
		var fieldsList;
		if(${(FMCustomerSearchForm.consentInd)}){ 
			fieldsList = new Array("sciLegalName", "atlasCode", "atlasProfileName", "atlasShortName");
		} else {
			fieldsList = new Array("atlasCode", "atlasProfileName", "atlasShortName");
		}
		var fieldNameJQ;
		for ( var i = 0; i < fieldsList.length; i++) {
			fieldNameJQ = '#' + fieldsList[i];
			if ($('input[name="' + fieldsList[i] + '"]').length >= 1) {
				$('input[name="' + fieldsList[i] + '"]').attr(
						'id', fieldsList[i]);
				paramOptions['suggestionsHolderDivId'] = '#suggestionsHolder_'
						+ fieldsList[i];
				paramOptions['fieldName'] = fieldsList[i];
				paramOptions['formName'] = 'FMCustomerSearchForm';
				$(fieldNameJQ).instantSearchFn(paramOptions);
			}
		}
		
	});

</script>
 --%>
<script language="javascript">
		function search() {
			var status = true;
			var inputSelector = 'input[type="text"][disabled="false"]';
			$(inputSelector).each( function(){
				
				if($(this).val().length > 0){
					searchString=jQuery.trim($(this).val());
					
					if(searchString.length>0)
						{
						status=true;
						}
					else
						{
						status=false;
						}
				}
			});
			
			if (status) {
				window.document.forms[0].action = "${pageContext.request.contextPath}/FMCustomerSearchList.do?Action=custSearchList";
				window.document.forms[0].submit();
			} else {
				showDialog("Enter Any Search Criteria");
				resetAll();
			}
		}
		
		function pndRecordsSearch() {
			window.document.forms[0].action = "${pageContext.request.contextPath}/FMCustomerPendingList.do?Action=custPendingList";
			window.document.forms[0].submit();
		}
		
		function resetAll() {
			var inputSelector = 'input[type="text"]';
			if($(inputSelector).hasClass('inputfield')) {
				$(inputSelector).attr('value','');
				$(inputSelector).attr('disabled',false);
				$(inputSelector).removeClass('inputfieldprotected');
			}
		}
		
		function loadCDDSearch() {
			var sStr = "./jsp/CddNoSearch.jsp";

			javascript: window
					.open(
							sStr,
							'new',
							'left=15,top=35,height=350,width=1000,resizable=1,scrollbars=2,status=1,titlebar=yes,toolbar=yes,titlebar=1,location=yes')

		}
		
		function disableEnableFields(triggeredObj){
			var inputSelector = 'input[type="text"]';
				if($(triggeredObj).attr('value') != '' && $(inputSelector).hasClass('inputfield')) {
					$(inputSelector).attr('disabled',true);
					$(inputSelector).addClass('inputfieldprotected');
					
					$(triggeredObj).attr('disabled',false);
					$(triggeredObj).removeClass('inputfieldprotected');
					$('a[name="searchBtn"]').focus();
				} else if($(inputSelector).hasClass('inputfield')){
					$(inputSelector).attr('disabled',false);
					$(inputSelector).removeClass('inputfieldprotected');
				}
				$(inputSelector+'[name!="'+$(triggeredObj).attr("name")+'"]').attr('value','');
				
		}
		
		function goCreate(){
			
			if(document.forms[0].consentInd.value==true)
				window.document.forms[0].action = "${pageContext.request.contextPath}/SCIGlobalProfile.do?Action=New&profileType=NONWBFM&consent=Y&mode=I";
			else
				window.document.forms[0].action = "${pageContext.request.contextPath}/SCIGlobalProfile.do?Action=New&profileType=NONWBFM&consent=N&mode=I";
			window.document.forms[0].submit();
		}
		
		$(document).ready(function() {
			
			$('input[type="text"]').each( function(){
				$(this).blur(function() {
					disableEnableFields(this);
				});
			});
		});
		
</script>
		
<style>
.suggestionRow {
	font-weight: normal;
	background: #FFFFFF;
}

.selected {
	background: #BEBCBC;
	font-weight: normal;
}
</style>

<table width="100%" cellpadding=0 cellspacing=0>
	<tr>
		<td>
		 <html:form action="FMCustomerSearch.do?Action=custSearchList"
				method="post">
				<div class="divMainPanels">
				<table class="boxbg" width="100%" cellpadding="0" cellspacing="0" border="0">
					<tr>
						<td>
							<table class="boxbg" width="100%" border="0">
							
							<logic:equal
														name="FMCustomerSearchForm" property="consentInd"
														value="false">
								<tr class="formheader">
									<td class="formlabel"><bean:message
											key="FMCustSearch.Heading" />&nbsp;Non Consent</td>
								</tr>
								</logic:equal>
								<logic:equal
														name="FMCustomerSearchForm" property="consentInd"
														value="true">
								<tr class="formheader">
									<td class="formlabel"><bean:message
											key="FMCustSearch.Heading" />&nbsp;Consent</td>
								</tr>
								</logic:equal>
							</table>
							
								<table class="boxbg" width="100%">
									<tr class="DETAILTR">
										<td>
										<%-- Only CONSENT type Search fields start --%>
										<%-- If Consent Indicator is set to true --%> 
										<c:if test="${(FMCustomerSearchForm.consentInd)}">
									<!-- 	<div class="divPanels">
											<table width="100%">
												<tr class="formtitle">
													<td colspan="6"><font
														>CDD Verification 
													</td>
												</tr>
												<tr >
													<logic:equal name="FMCustomerSearchForm"
														property="cddSearchIsEnabled" value="true">
														<td colspan="6">
															<center>

																<html:button styleClass="newcssbutton"
																	property="cddSearchBtn" onclick="loadCDDSearch()">
																	<bean:message key="button.cddSearch" />
																</html:button>

															</center></td>
													</logic:equal>

												</tr>
												</table>
												</div>-->
												<div class="divPanels">
												<table width="100%">
												<tr class="formtitle">
													<td colspan="6" class="formlabel">SCI Field Search 
													</td>
												</tr>
												<tr>
													<td class="formlabel">SCI LE Id</td>
													<td><logic:equal
															name="FMCustomerSearchForm" property="sciLeIdIsEnabled"
															value="true">
                                                        &nbsp;<html:text
																property="sciLeId" maxlength="10" size="15"
																styleClass="inputfield Numbers " />
														</logic:equal> <logic:notEqual name="FMCustomerSearchForm"
															property="sciLeIdIsEnabled" value="true">
                                                        &nbsp;<html:text
																property="sciLeId" maxlength="10" size="15"
																styleClass="inputfieldprotected" disabled="true" />
														</logic:notEqual>
													</td>

													<td class="formlabel">SCI Legal Name</td>
													<td  ><logic:equal
															name="FMCustomerSearchForm"
															property="sciLegalNameIsEnabled" value="true">
                                                        &nbsp;<html:text
																property="sciLegalName" maxlength="100" size="30"
																styleClass="inputfield AlphaNumericWSPU ConvertToUpper " />
															<br />
															<div id="suggestionsHolder_sciLegalName"
																style="display: none"></div>
														</logic:equal> <logic:notEqual name="FMCustomerSearchForm"
															property="sciLegalNameIsEnabled" value="true">
                                                        &nbsp;<html:text
																property="sciLegalName" maxlength="100" size="30"
																styleClass="inputfieldprotected" disabled="true" />
														</logic:notEqual>
													</td>

													<td class="formlabel">SCI Cross Ref Id <font size="1pt">(Only for ATLAS/CDD/CRM Ids)</font></td>
													<td  ><logic:equal
															name="FMCustomerSearchForm"
															property="sciCrossRefIdIsEnabled" value="true">
                                                    	&nbsp;<html:text
																property="sciCrossRefValue" maxlength="10" size="15"
																styleClass="inputfield AlphaNumericWS ConvertToUpper " />
														</logic:equal> <logic:notEqual name="FMCustomerSearchForm"
															property="sciCrossRefIdIsEnabled" value="true">
                                                    	&nbsp;<html:text
																property="sciCrossRefValue" maxlength="10" size="15"
																styleClass="inputfieldprotected" disabled="true" />
														</logic:notEqual>
													</td>
												</tr>
												<tr>
													<td ></td>
													<td  colspan="5"></td>
												</tr>
												</tr>
											</table>
											</div>
											</c:if>
											<%-- CONSENT type Search fields end --%>
											
											<%-- Both CONSENT and NON-CONSENT type Search fields start --%>
											<div class="divPanels">
											<table width="100%">
												<tr class="formtitle">
													<td colspan="6" class="formlabel">FM Field Search 
													</td>
												</tr>
												<!-- Insert Codes -->
												<tr>
													<td class="formlabel">Atlas Code</td>
													<td  ><logic:equal
															name="FMCustomerSearchForm" property="atlasCodeIsEnabled"
															value="true">
                                                        &nbsp;<html:text
																property="atlasCode" maxlength="30" size="15"
																styleClass="inputfield AlphaNumericFMCode ConvertToUpper " />
															<br />
															<div id="suggestionsHolder_atlasCode"
																style="display: none"></div>

														</logic:equal> <logic:notEqual name="FMCustomerSearchForm"
															property="atlasCodeIsEnabled" value="true">
                                                        &nbsp;<html:text
																property="atlasCode" maxlength="30" size="15"
																styleClass="inputfieldprotected" disabled="true" />
														</logic:notEqual>
													</td>

													<td class="formlabel">Atlas Profile Id</td>
													<td  ><logic:equal
															name="FMCustomerSearchForm"
															property="altasProfileIdIsEnabled" value="true">
                                                        &nbsp;<html:text
																property="altasProfileId" maxlength="10" size="15"
																styleClass="inputfield Numbers ConvertToUpper " />
														</logic:equal> <logic:notEqual name="FMCustomerSearchForm"
															property="altasProfileIdIsEnabled" value="true">
                                                        &nbsp;<html:text
																property="altasProfileId" maxlength="10" size="15"
																styleClass="inputfieldprotected" disabled="true" />
														</logic:notEqual>
													</td>

													<td class="formlabel">Atlas Swift Code</td>
													<td  ><logic:equal
															name="FMCustomerSearchForm"
															property="atlasShiftCodeIsEnabled" value="true">
                                                        &nbsp;<html:text
																property="atlasShiftCode" maxlength="250" size="15"
																styleClass="inputfield AlphaNumericWS ConvertToUpper " />
														</logic:equal> <logic:notEqual name="FMCustomerSearchForm"
															property="atlasShiftCodeIsEnabled" value="true">
                                                        &nbsp;<html:text
																property="atlasShiftCode" maxlength="250" size="15"
																styleClass="inputfieldprotected" disabled="true" />
														</logic:notEqual>
													</td>

												</tr>
												<tr>
													<td class="formlabel">Atlas TCID Code</td>
													<td  ><logic:equal
															name="FMCustomerSearchForm"
															property="atlasTCIDCodeIsEnabled" value="true">
                                                        &nbsp;<html:text
																property="atlasTCIDCode" maxlength="4" size="15"
																styleClass="inputfield AlphaNumeric ConvertToUpper " />
														</logic:equal> <logic:notEqual name="FMCustomerSearchForm"
															property="atlasTCIDCodeIsEnabled" value="true">
                                                        &nbsp;<html:text
																property="atlasTCIDCode" maxlength="4" size="15"
																styleClass="inputfieldprotected AlphaNumeric" disabled="true" />
														</logic:notEqual>
													</td>

													<td class="formlabel">Atlas Profile
														Name</td>
													<td  ><logic:equal
															name="FMCustomerSearchForm"
															property="atlasProfileNameIsEnabled" value="true">
                                                        &nbsp;<html:text
																property="atlasProfileName" maxlength="35" size="15"
																styleClass="inputfield AlphaNumericWSPU ConvertToUpper " />
															<br />
															<div id="suggestionsHolder_atlasProfileName"
																style="display: none"></div>
														</logic:equal> <logic:notEqual name="FMCustomerSearchForm"
															property="atlasProfileNameIsEnabled" value="true">
                                                        &nbsp;<html:text
																property="atlasProfileName" maxlength="35" size="15"
																styleClass="inputfieldprotected" disabled="true" />
														</logic:notEqual>
													</td>

													<td class="formlabel" >Atlas Short Name</td>
													<td  ><logic:equal
															name="FMCustomerSearchForm"
															property="atlasShortNameIsEnabled" value="true">
                                                        &nbsp;<html:text
																property="atlasShortName" maxlength="35" size="30"
																styleClass="inputfield AlphaNumericWSPU ConvertToUpper " />
															<br />
															<div id="suggestionsHolder_atlasShortName"
																style="display: none"></div>
														</logic:equal> <logic:notEqual name="FMCustomerSearchForm"
															property="atlasShortNameIsEnabled" value="true">
                                                        &nbsp;<html:text
																property="atlasShortName" maxlength="35" size="30"
																styleClass="inputfieldprotected" disabled="true" />
														</logic:notEqual>
													</td>
												</tr>
												<td class="formlabel">Atlas Cross Ref Id</td>
												<td  ><logic:equal
														name="FMCustomerSearchForm"
														property="atlasCrossRefIdIsEnabled" value="true">
                                                    	&nbsp;<html:text
															property="atlasCrossRefId" maxlength="30" size="15"
															styleClass="inputfield AlphaNumericFMCode ConvertToUpper " />
													</logic:equal> <logic:notEqual name="FMCustomerSearchForm"
														property="atlasCrossRefIdIsEnabled" value="true">
                                                        &nbsp;<html:text
															property="atlasCrossRefId" maxlength="30" size="15"
															styleClass="inputfieldprotected" disabled="true" />
													</logic:notEqual>
												</td>
												<tr>
												</tr>
											</table>
											</div> 
											<br> 
										<%-- Both CONSENT and NON-CONSENT type Search fields end --%>
										
										<table width="100%">
											<tr align="center">
												<td colspan="6" >
												
													<logic:equal name="FMCustomerSearchForm" property="searchBtnIsEnabled" value="true">
														&nbsp;&nbsp;<a class="newcssbutton"  href="javascript:search();" name="searchBtn"><ins> <bean:message key="button.search" /></ins></a>
													</logic:equal>
													
													<logic:equal name="FMCustomerSearchForm" property="consentInd" value="false">
													<c:if test="${((sessionScope.UserProfile.majorRoleTypeValue ne null) && (sessionScope.UserProfile.majorRoleTypeValue eq 'FMMAKER'))}">
														&nbsp;&nbsp;<a class="newcssbutton" href="javascript:goCreate();"  name="Proceed"><ins> Create New LE / FM Profile</ins></a>
													</c:if>
													</logic:equal>
													
													<logic:equal name="FMCustomerSearchForm" property="listAllPndRecBtnIsEnabled"  value="true">
														&nbsp;&nbsp;<a  class="newcssbutton" href="javascript:pndRecordsSearch()" name="listAllPndRecBtn"><ins> <bean:message key="button.ListAllPendingRecords"/> </ins></a>
													</logic:equal>
													
													&nbsp;&nbsp;<a class="newcssbutton"  href="javascript:resetAll();" name="clearBtn"><ins> <bean:message key="button.clear" /> </ins></a>
													
												</td>
											</tr>
										</table>
										<br>
										</td>
									</tr>
								</table>
								<table>
									<tr class="BODYCONTENTFOOTER">
										<td class="BODYCONTENTFOOTERTEXT">&nbsp;</td>
									</tr>
								</table>
						</td>
					</tr>
				</table>
				</div>
				<html:hidden property="consentInd" />
			</html:form></td>
	</tr>
</table>