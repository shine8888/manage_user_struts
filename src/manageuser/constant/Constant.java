/**
 * Copyright (C) Luvina Development
 */
package manageuser.constant;

import manageuser.common.Common;

/**
 * @author kieuvanquang
 *
 */
public class Constant {

	public static final String LOGIN_NAME = "loginName";

	// list dùng trong chương trình
		public static final String LIST_USER = "listUser";
		public static final String LIST_JAPAN = "listJapan";
		public static final String LIST_GROUP = "listGroup";
		public static final String LIST_PAGING = "listPaging";

		// action thực hiện của chương trình
//		public static final String ACTION = "action";
		public static final String SEARCH = "search";
		public static final String SORT = "sort";
		public static final String PAGING = "paging";
		public static final String BACK = "back";
		public static final String CONFIRM = "confirm";
//		public static final String TYPE = "type";

		// set value defaul screen ADM002
		public static final Integer DEFAUT_CURRENT_PAGE = 1;
		public static final Integer DEFAULT_OFFSET = 0;
		public static final Integer DEFAULT_JAPAN_ID = 0;
		public static final String DEFAUT_FULLNAME = "";

		// use param screen ADM002
		public static final String SORT_FULLNAME = "full_name";
		public static final String SORT_CODELEVEL = "code_level";
		public static final String SORT_ENDDATE = "end_date";
		public static final String SORT_ASC = "ASC";
		public static final String SORT_DESC = "DESC";
		public static final String SORT_BY_FULL_NAME = "sortByFullName";
		public static final String SORT_BY_CODE_LEVEL = "sortByCodeLevel";
		public static final String SORT_BY_END_DATE = "sortByEndDate";
		public static final String DEFAULT = "default";
		public static final String LIMIT_RECORD = "limit_record";
		public static final String LIMIT_PAGE = "limit_page";
		public static final String CURRENT_PAGE = "currentPage";

		
		// use param screen ADM003
//		public static final String USER_ID = "userId";
		public static final String GROUP_ID = "groupId";
		public static final String GROUP_NAME = "groupName";
		public static final String FULL_NAME = "fullName";
		
		

	

		public static final String ER011_BIRTHDAY = "ER011_BIRTHDAY";


		public static final String ER017_PASSWORD_CONFIRM = "ER017_PASSWORD_CONFIRM";

		public static final String ER004_LEVEL = "ER004_LEVEL";

		public static final String ER011_START_DATE = "ER011_START_DATE";

		public static final String ER011_END_DATE = "ER011_END_DATE";
		public static final String ER012_END_DATE = "ER012_END_DATE";

		public static final String ER001_TOTAL = "ER001_TOTAL";
		public static final String ER018_TOTAL = "ER018_TOTAL";
		public static final String ER006_TOTAL = "ER006_TOTAL";
		// Max and Min length
		public static final Integer MAX_LENGTH = 255;
		public static final Integer MAX_LOGIN_NAME = 15;
		public static final Integer MIN_LOGIN_NAME = 4;
		public static final Integer MAX_EMAIL = 100;
		public static final Integer MAX_TEL = 14;
		public static final Integer MAX_PASSWORD = 15;
		public static final Integer MIN_PASSWORD = 5;
		public static final Integer MAX_TOTAL = 11;
		
		// Các hằng lưu giá trị cho các mã lỗi
		public static final String ER001_LOGIN_NAME = "ER001_LOGIN_NAME";
		public static final String ER007_LOGIN_NAME = "ER007_LOGIN_NAME";
		public static final String ER019_LOGIN_NAME = "ER019_LOGIN_NAME";
		public static final String ER003_LOGIN_NAME = "ER003_LOGIN_NAME";
		public static final String ER016_LOGIN_NAME = "ER016_LOGIN_NAME";
		
		public static final String ER002_GROUP_NAME = "ER002_GROUP_NAME";
		public static final String ER004_GROUP_NAME = "ER004_GROUP_NAME";
		
		public static final String ER001_FULL_NAME = "ER001_FULL_NAME";
		public static final String ER006_FULL_NAME = "ER006_FULL_NAME";
		public static final String ER001_FULL_NAME_KANA = "ER001_FULL_NAME_KANA";
		public static final String ER009_FULL_NAME_KANA = "ER009_FULL_NAME_KANA";
		public static final String ER006_FULL_NAME_KANA = "ER006_FULL_NAME_KANA";
		
		public static final String ER001_BIRTH_DAY = "ER001_BIRTH_DAY";
		public static final String ER011_BIRTH_DAY = "ER011_BIRTH_DAY";
		
		public static final String ER001_EMAIL = "ER001_EMAIL";
		public static final String ER006_EMAIL = "ER006_EMAIL";
		public static final String ER005_EMAIL = "ER005_EMAIL";
		public static final String ER003_EMAIL = "ER003_EMAIL";
		
		public static final String ER001_TEL = "ER001_TEL";
		public static final String ER006_TEL = "ER006_TEL";
		public static final String ER005_TEL = "ER005_TEL";
		
		public static final String ER001_PASSWORD = "ER001_PASSWORD";
		public static final String ER007_PASSWORD = "ER007_PASSWORD";
		public static final String ER008_PASSWORD = "ER008_PASSWORD";
		public static final String ER001_CONFIRM_PASSWORD = "ER001_CONFIRM_PASSWORD";
		public static final String ER017_CONFIRM_PASSWORD = "ER017_CONFIRM_PASSWORD";

		public static final String ER004_LEVEL_NAME = "ER004_LEVEL_NAME";
		
		

		public static final String ER008 = "ER008";
		public static final String ER009 = "ER009";
		public static final String ER012 = "ER012";
		public static final String ER013 = "ER013";
		public static final String ER014 = "ER014";
		public static final String ER015 = "ER015";
		public static final String ER016 = "ER016";
		public static final String ER017 = "ER017";
		public static final String ER018 = "ER018";
		public static final String ER019 = "ER019";
		public static final String ER020 = "ER020";
		public static final String ER021 = "ER021";
		public static final String MSG001 = "MSG001";
		public static final String MSG002 = "MSG002";
		public static final String MSG003 = "MSG003";
		public static final String MSG004 = "MSG004";
		public static final String MSG005 = "MSG005";

		public static final int YEAR_BEGINING = 2000;

		public static final int YEAR_END = Common.getYearNow();

		public static final int YEAR_ENDDATE = Common.getYearNow()+1;

		public static final String N0 = "N0";

		
	}
