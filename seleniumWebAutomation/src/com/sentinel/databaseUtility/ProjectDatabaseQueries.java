package com.sentinel.databaseUtility;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.sentinel.driver.WebDriverTestBase;
import com.sentinel.utils.DatabaseConnection;
import com.sentinel.utils.ExcelUtility;
import com.sentinel.utils.GenericFunctions;

public class ProjectDatabaseQueries extends WebDriverTestBase {

	String stringValue = null, fileNameAndExtension = null, sheetName = null;;
	String query = null;
	int intValue = 0, incrementalValue = 0, xlValues = 0;;
	GenericFunctions genericFunctions = new GenericFunctions();
	ExcelUtility data = new ExcelUtility();
	ArrayList<String> arrayListValue = null, arrayListValue1 = null, arrayListValue2;
	LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();

	public String updateAndGetEmailAddressDataBase() {
		try {
			stringValue = genericFunctions.generateRandomEmail();

			query = "update pmn.tblcontact set email='" + stringValue + "' where firstname='"
					+ config.getProperty("firstName") + "'";
			DatabaseConnection.executeQuery(query);
			logger.debug(query);
			DatabaseConnection.executeQuery("Commit");
			logger.debug("Email Id updated in Db is - " + stringValue);

			query = "SELECT email FROM pmn.tblcontact where active=1 and firstname='" + config.getProperty("firstName")
					+ "'";
			arrayListValue = DatabaseConnection.executeQuery(query);

			logger.debug(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayListValue.get(0);

	}

	public String getUserName(String stringValue) {
		try {
			query = "SELECT username FROM `tblcontact` WHERE email = '" + stringValue + "';";
			logger.debug(query);
			arrayListValue = DatabaseConnection.executeQuery(query);
			logger.debug("The UserName is " + arrayListValue.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayListValue.get(0);
	}

	public void checkContactIdCountInOTPTableUpdateIfNeeded(String dbValue) {
		try {
			String temp = null;
			query = "SELECT id FROM `tblcontact` WHERE firstname = '" + config.getProperty("firstName")
					+ "' AND email = '" + dbValue + "'";
			arrayListValue = DatabaseConnection.executeQuery(query);
			logger.debug(query);
			temp = arrayListValue.get(0);

			query = "SELECT count(contact_id) as contactCount FROM `otp` where contact_id=" + arrayListValue.get(0)
					+ "";
			arrayListValue = DatabaseConnection.executeQuery(query);
			logger.debug(query);
			intValue = Integer.valueOf(arrayListValue.get(0));
			if (intValue >= 5) {
				query = "delete from otp where contact_id='" + temp + "'";
				arrayListValue = DatabaseConnection.executeQuery(query);
				logger.debug("Deleted the values from table since value count was greeter =5. " + query);
			}
			logger.debug(
					"Verified the count of contact id in OTP Table,i.e it should not be equal to 5 for OTP Process... ");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getOTPFromDB(String dbValue) {
		try {
			query = "SELECT id FROM `tblcontact` WHERE firstname = '" + config.getProperty("firstName")
					+ "' AND email = '" + dbValue + "'";
			arrayListValue = DatabaseConnection.executeQuery(query);
			logger.debug(query);

			query = "SELECT otp_value FROM `otp` WHERE contact_id=" + arrayListValue.get(0) + " and to_email= '"
					+ dbValue + "' order by created desc LIMIT 1";
			arrayListValue = DatabaseConnection.executeQuery(query);
			logger.debug(query);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayListValue.get(0);
	}

	public String getUsername() {
		try {
			query = "SELECT username FROM `tblcontact`where firstname='" + config.getProperty("firstName") + "'";
			arrayListValue = DatabaseConnection.executeQuery(query);
			logger.debug(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayListValue.get(0);
	}

	public int GetOtpCountForEmailID(String dbValue) {
		try {

			query = "SELECT id FROM `tblcontact` WHERE firstname = '" + config.getProperty("firstName")
					+ "' AND email = '" + dbValue + "'";
			arrayListValue = DatabaseConnection.executeQuery(query);
			logger.debug(query);
			query = "SELECT count(contact_id) as contactCount FROM `otp` where contact_id=" + arrayListValue.get(0)
					+ "";
			arrayListValue = DatabaseConnection.executeQuery(query);
			logger.debug(query);
			intValue = Integer.valueOf(arrayListValue.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return intValue;
	}

	public String getNoOfAttemptsFromDB(String dbValue) {
		try {
			query = "SELECT ifnull(no_of_attempts,0) AS noOfAttempts FROM pmn.otp where to_email='" + dbValue + "' ";
			arrayListValue = DatabaseConnection.executeQuery(query);
			logger.debug("Got the no. of attempts from the database - " + query);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayListValue.get(0);
	}

	public int getInvalidLoginCountUpdateIfNeeded(String dbValue) {
		try {
			String temp = null;
			query = "SELECT id FROM `tblcontact` WHERE firstname = '" + config.getProperty("firstName")
					+ "' AND email = '" + dbValue + "'";
			arrayListValue = DatabaseConnection.executeQuery(query);
			logger.debug(arrayListValue.get(0) + "is the Id in db -- >" + query);
			temp = arrayListValue.get(0);

			query = "SELECT count(user_contact_id) as userContactCount FROM `tbllogin_attempts` where user_contact_id="
					+ temp + "";
			arrayListValue = DatabaseConnection.executeQuery(query);
			logger.debug(arrayListValue.get(0) + " is the count in the db,query is - " + query);
			intValue = Integer.valueOf(arrayListValue.get(0));
			if (((intValue >= 5) && (incrementalValue == 0)) || (incrementalValue == 2)) {
				query = "delete from `tbllogin_attempts` where user_contact_id='" + temp + "'";
				arrayListValue = DatabaseConnection.executeQuery(query);
				logger.debug("Deleted the values from table since value count was >=5. " + query);
				// update the active column in Table: tblcontact
				query = "update `tblcontact` set active='1' where id='" + temp + "'";
				arrayListValue = DatabaseConnection.executeQuery(query);
				logger.debug("Update the tblcontact set Active=1 " + query);

				// Again take the count after deleting
				query = "SELECT count(user_contact_id) as userContactCount FROM `tbllogin_attempts` where user_contact_id="
						+ temp + "";
				arrayListValue = DatabaseConnection.executeQuery(query);
				intValue = Integer.valueOf(arrayListValue.get(0));
				logger.debug(intValue + " is the count in the db,query is - " + query);

			}
			if (incrementalValue == 2) {
				incrementalValue = 0;
			} else {
				incrementalValue++;
			}
			logger.debug(
					"Verified the count of contact id in tblcontact Table,i.e it should not be equal to 5 for Login Process... ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return intValue;
	}

	public int getActiveColoumnValue(String dbValue) {
		try {
			// Get the Id of the user
			query = "SELECT id FROM `tblcontact` WHERE firstname = '" + config.getProperty("firstName")
					+ "' AND email = '" + dbValue + "'";
			arrayListValue = DatabaseConnection.executeQuery(query);
			logger.debug(arrayListValue.get(0) + "is the Id in db -- >" + query);
			// Get the Active Coloumn value for the user from the database
			query = "SELECT `tblcontact`.`active` FROM `tblcontact` where id=" + arrayListValue.get(0) + "";
			arrayListValue = DatabaseConnection.executeQuery(query);
			intValue = Integer.valueOf(arrayListValue.get(0));
			logger.debug(intValue + " is the Active coloumn value in 'tblcontact' table in the db,query is - " + query);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return intValue;
	}

	public ArrayList<String> getFacilityDataForFirstRow() {
		try {
			query = "SELECT facilityid, facilityname, phone, datecreated, (CASE WHEN active =0 THEN \"Inactive\" ELSE \"Active\" END ) FROM `tblfacility` where entitytypeid='4' ORDER BY parentid,facilityid desc LIMIT 1";
			arrayListValue = DatabaseConnection.executeQuery(query);
			logger.debug("Query to get the facility listing data from the db is - " + query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayListValue;
	}

	public LinkedHashMap<Object, Object> getAddedAddressValues(ArrayList<String> arrayListValue) {
		try {
			sheetName = "tableHeader";
			fileNameAndExtension = "addressPageExcelSheet.xls";

			// Get All the Address Data from DB
			query = "SELECT addresstypeid,address,address2,stateid,cityid,zip FROM `tbladdress` where facilityid="
					+ getFacilityDataForFirstRow().get(0) + "";
			// this step overrites the arraylistvalue
			arrayListValue = DatabaseConnection.executeQuery(query);
			// 1. Get Address type
			query = "SELECT name FROM `tbladdresstype` where addresstypeid=" + arrayListValue.get(0) + "";

			// arrayListValue = DatabaseConnection.executeQuery(query);
			arrayListValue.set(0, DatabaseConnection.executeQuery(query).toString());

			// 2. State ID
			query = "SELECT name FROM `tblstate` where stateid=" + arrayListValue.get(3) + "";
			arrayListValue.set(3, DatabaseConnection.executeQuery(query).toString());

			// 3. City ID
			query = "SELECT name FROM `tblcity` where cityid=" + arrayListValue.get(4) + "";
			arrayListValue.set(4, DatabaseConnection.executeQuery(query).toString());

			intValue = (data.readData(sheetName, fileNameAndExtension).size() - 6);

			while (xlValues < intValue) {
				for (int i = 0; i < arrayListValue.size(); i++) {
					if ((i == 2)) {
						stringValue = arrayListValue.get(i - 1).replace("[", "").replace("]", "")
								+ arrayListValue.get((i)).replace("[", "").replace("]", "").replace("-", "");
						linkedHashMap.put(data.readData(sheetName, fileNameAndExtension).get(xlValues), stringValue);
					}
					if ((i != 1) && (i != 2)) {
						linkedHashMap.put(data.readData(sheetName, fileNameAndExtension).get(xlValues),
								arrayListValue.get(i).replace("[", "").replace("]", "").replace("-", ""));
					}
					if (i != 1) {
						xlValues++;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return linkedHashMap;
	}

	public String getActiveUserPhoneNumber() {
		try {
			query = "SELECT email FROM `tblcontact`where active=1 and permitlogin=1 ORDER BY RAND() DESC LIMIT 1";
			arrayListValue = DatabaseConnection.executeQuery(query);
			logger.debug("Query to get the random phone number from the db is - " + query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayListValue.get(0);

	}

	public ArrayList<String> getNewContactData(String... args) {
		try {

			if (args[0].equals("All Fields")) {
				Thread.sleep(5000);
				query = "SELECT tblcontact.username,tblcontact.salutation,tblcontact.title,tblcontact.firstname,tblcontact.lastname,tblcontact.email,tblcontact.cellphone, (CASE WHEN tblcontact.billing=1 THEN \"YES\" ELSE \"NO\" END) billing,tblcontact.ext,tblcontact.businessphone,tblcontact.fax,tblcontact.dept FROM `tblcontact` where tblcontact.creatorid=90 and tblcontact.active=1 ORDER BY `id` DESC LIMIT 1";
				arrayListValue = DatabaseConnection.executeQuery(query);
				logger.debug("Query to get the new contact data from the db is - " + query);
				query = "SELECT name FROM `tbldepartment` WHERE departmentid=" + arrayListValue.get(11) + "";
				logger.debug("Query to get the department vlaue from the db is - " + query);
				// remove last entry as 1 from the array list and add from
				// department at 11
				arrayListValue.remove(11);
				arrayListValue1 = DatabaseConnection.executeQuery(query);
				arrayListValue.add(11, arrayListValue1.get(0));
			} else {
				query = "SELECT concat(firstname,\" \",lastname) as contactName,title,cellphone,email,fax,(CASE WHEN ACTIVE=1 THEN \"Active\" ELSE \"Inactive\" END)status FROM `tblcontact` where tblcontact.creatorid=90 and tblcontact.active=1 ORDER BY id desc LIMIT 1";
				arrayListValue = DatabaseConnection.executeQuery(query);
				logger.debug("Query to get the new contact lsiting data from the db is - " + query);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayListValue;
	}

	public ArrayList<String> getFacilityWithCityState(String... args) {
		try {
			query = "SELECT a2.facilityname,a1.cityid,a1.stateid,a2.phone,DATE_FORMAT(a2.datecreated,'%d/%m/%Y') as dateCreated,(CASE WHEN a2.active=1 THEN \"Active\" else \"Inactive\" END) as status FROM tbladdress a1 INNER JOIN tblfacility a2 on a1.facilityid=a2.facilityid where a1.addresstypeid=3 order by rand() limit 1";
			arrayListValue = DatabaseConnection.executeQuery(query);
			logger.debug("Query to get the city,state id from the db is - " + query);
			query = "SELECT a2.name as state ,a1.name as city FROM tblcity a1 INNER JOIN tblstate a2 on a1.state_id=a2.stateid where a1.cityid='"
					+ arrayListValue.get(1) + "' and a2.stateid=" + arrayListValue.get(2) + "";
			arrayListValue1 = DatabaseConnection.executeQuery(query);
			logger.debug("Query to get the city,state name from the db is - " + query);

			arrayListValue.remove(1);
			arrayListValue.remove(1);
			arrayListValue.add(1, arrayListValue1.get(0));
			arrayListValue.add(2, arrayListValue1.get(1));
			for (int i = 0; i < arrayListValue.size(); i++) {
				logger.debug(i + " - " + arrayListValue.get(i));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayListValue;
	}

	public ArrayList<String> getDepartmentListFromDB(String... args) {
		try {
			if (args.length > 0) {
				/**
				 * At present Admin created department list ***only department
				 * name*** list
				 */
				if (args[0].equals("getExisitingAdminDepartmentsOrderedByName")) {
					query = "SELECT name FROM `tbldepartment` where createdby_network ='1' and active=1 and name not in ('General')order by name";
					arrayListValue = DatabaseConnection.executeQuery(query);
					logger.debug("Query to get the department List data from the db is - " + query);
				}
				/**
				 * At present Admin created department list ***only department
				 * name*** list
				 */
				if (args[0].equals("getExisitingAdminDepartments")) {
					query = "SELECT name FROM `tbldepartment` where createdby_network ='1' order by datecreated desc";
					arrayListValue = DatabaseConnection.executeQuery(query);
					logger.debug("Query to get the department List data from the db is - " + query);
				}
				/**
				 * Search Functionality Query
				 */
				if (args[0].equals("searchFunctionalityQuery")) {
					query = "SELECT name,(case wheN active=1 then \"Active\" else \"Inactive\" END ) As STATUS,departmentid FROM `tbldepartment` where name LIKE '%"
							+ args[1] + "%' and createdby_network=1 order by name desc";
					arrayListValue = DatabaseConnection.executeQuery(query);
					logger.debug("Query to get the department List data from the db is - " + query);
				}
				/***
				 * faciltyDeartment Default List
				 */
				if (args[0].equals("facilityDepartment")) {
					query = "SELECT name,(case wheN active=1 then \"Active\" else \"Inactive\" END ) As STATUS,departmentid FROM `tbldepartment` where name LIKE '%"
							+ args[1] + "%' and createdby_network=1 order by name desc";
					arrayListValue = DatabaseConnection.executeQuery(query);
					logger.debug("Query to get the department List data from the db is - " + query);
				}
			} else {
				/**
				 * complete department list
				 */
				query = "SELECT name,(case wheN active=1 then \"Active\" else \"Inactive\" END ) As STATUS,departmentid FROM `tbldepartment` where createdby_network ='1' order by datecreated desc";
				arrayListValue = DatabaseConnection.executeQuery(query);
				logger.debug("Query to get the department List data from the db is - " + query);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayListValue;
	}

	public ArrayList<String> getActionValueFromDB(String deptID) {
		try {
			query = "SELECT count(facilityid) as deptUsedCount FROM `tblassign_facilitydepartment` where departmentid in("
					+ deptID + ")";
			arrayListValue = DatabaseConnection.executeQuery(query);
			logger.debug("Query to get the action value from the db is - " + query);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayListValue;
	}

	public ArrayList<String> getDepartmentData(String departmentName,String facilityDetials) {
		try {

			/**
			 * GET THE FACILITY ID
			 */
			query = "SELECT IFNULL(facilityid,'0') AS facilityid FROM `tblfacility` where facilityname='"
					+ facilityDetials + "'";
			arrayListValue = DatabaseConnection.executeQuery(query);
			logger.debug("Query to get departmentid,facilityid,name value from the db is - " + query);

			/**
			 * GET THE DEPARTMENT ID AND NAME
			 */
			query = "SELECT name,departmentid FROM `tbldepartment` where name='" + departmentName + "'";
			arrayListValue1 = DatabaseConnection.executeQuery(query);
			logger.debug("Query to get departmentid,facilityid,name value from the db is - " + query);

			arrayListValue1.add(2, arrayListValue.get(0));

			/**
			 * get the isadmin and active info
			 */

			query = "SELECT dept_isadmin,active FROM `tblassign_facilitydepartment` where departmentid="
					+ arrayListValue1.get(1) + " and facilityid=" + arrayListValue1.get(2) + "";
			arrayListValue2 = DatabaseConnection.executeQuery(query);
			logger.debug("Query to get departmentid,facilityid,name value from the db is - " + query);
			/**
			 * Assemble all the info in 3rd Array
			 */
			arrayListValue.clear();
			arrayListValue.add(0, arrayListValue1.get(0));
			for (int i = 1; i <= arrayListValue2.size(); i++) {
				arrayListValue.add(i, arrayListValue2.get(i - 1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayListValue;
	}

}
