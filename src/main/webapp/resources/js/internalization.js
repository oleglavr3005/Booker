var languages = {};
(function (){
	var en = {
		header_regist : "Registration",
		header_auth : "Sign In",
		
		header_auth : "Log In",
		header_auth_close : "Close",
		header_auth_forgot : "Forgot password",
		header_auth_enter : "Enter",
		
		index_search_header : "Find Hotel",
		index_search_name : "Destination/Hotel Name:",
		index_search_start : "Start date",
		index_search_end : "End date",
		index_search_price : "Stars",
		index_search_price_2 : "Price",
		index_search_ppl : "Guests",
		index_search_button : "Search",
		index_room_type : "Room type",
		index_room_type_standart : "Standart",
		index_room_type_lux : "Lux",
		index_room_type_delux : "Delux",
		index_room_type_food : "Room food",
		index_room_type_food_none : "None",
		index_room_type_food_breakfast : "Breakfast",
		index_room_type_food_twice: "Twice",
		index_room_type_food_full: "Full",
		index_room_wifi : "Wifi",
		index_room_shower : "Shower",
		index_room_parking : "Parking",
		index_room_conditioner : "Air conditioner",
		index_room_pool : "Swiming pool",
		index_room_gym : "Fit gym",
		index_room_balcony : "Balcony",
		index_room_noDeposit : "No deposit",

		map_button : "Map", 
		search : "Search",

		index_option_star_asc : "Star asc",
		index_option_star_desc : "Star desc",
		index_option_rating_asc : "Rating asc",
		index_option_rating_desc : "Rating desc",	

		concrete_date_from : "Check-in",
		concrete_date_to : "Check-out",
		footer_info : "Info",
		footer_visit : "Visit",
		footer_support : "Support",
		footer_social : "Social",
		footer_info_contact : "Contact Us",
		footer_info_terms : "Terms",
		footer_info_rules : "Rules",
		footer_info_faq : "FAQ",
		footer_info_story : "Story",
		footer_visit_home : "Home",
		footer_visit_news : "News",
		footer_visit_premium : "Premium",
		footer_visit_shop : "Shop",
		footer_visit_forum : "Forum",
		footer_support_center : "Center",
		footer_support_guides : "Guides",
		footer_support_tools : "Tools",
		footer_support_tutorial : "Tutorials",
		footer_support_webinars : "Webinars",
		footer_social_facebook : "Facebook",
		footer_social_twitter : "Twitter",
		footer_social_youtube : "YouTube",
		footer_social_pinterest : "Pinterest",
		footer_social_wordpress : "WordPress",
		footer_social_google_plus : "Google +", 
		footer_copyright : "All rights Reserved",

		header_regist_name : "First name",
		header_regist_surname : "Last name",
		header_regist_mail : "Email",
		header_regist_pass : "Password",
		header_regist_cpass : "Підтвердити пароль",
		header_regist_confirm : "Завершити реєстрацію",
		
		// authorization
		header_error_mail : "Invalid email",
		header_error_mailpass : "Invalid email or password",
		
		// user settings
		settings_header : " Your settings",
		settings_header_PERSONAL : "Personal information",
		settings_enter_name : "First name",
		settings_enter_surname : "Last name ",
		settings_enter_save : "Save",
		settings_header_pass : "Change password",
		settings_enter_passnew : " New password",
		settings_enter_passrepeat : "Repeat new password",
		settings_header_contact : "Contacts",
		settings_enter_phone : "Phone number",
		settings_header_manage : "Manager",
		settings_enter_request : "Request for manager",

		card_header : "All rights reserved_",
		card_no_periodicals : "No numbers found",
		card_no_hotels: "No Hotels",
		room_card_count: "Total price??",

		subscribes_header : "List of orders",
		card_status_active : "Active",
		subscribes_table_remove : "Delete order",
		subscribes_empty : "Not Found??",
		subscribes_table_name : "Hotel",
		subscribes_table_startDate : "Check-in",
		subscribes_table_endDate: "Check-out",
		subscribes_table_price: "Price",
		subscribes_table_status: "Status",
		card_status_ended : "Removed??",
		card_status_removed : "Order cancelled??",

		user_cart_header :"Shopping Cart"
	}
	var ua = {
		header_regist : "Регістрація",
		header_auth : "Увійти",
		
		header_auth : "Увійти",
		header_auth_close : "Закрити",
		header_auth_forgot : "Забули пароль?",
		header_auth_enter : "Увійти",
		
		index_search_header : "Шукати готель",
		index_search_name : "Місце/назва готелю:",
		index_search_price : "Зірки",
		index_search_ppl : "Гостей",
		index_search_start : "Приїжджаю",
		index_search_end : "Від'їжджаю",
		index_search_price_2 : "Ціна",
		index_search_button : "Пошук",
		
		map_button : "Карта", 
		search : "Пошук",
		
		concrete_date_from : "Приїжджаю",
		concrete_date_to : "Від'їжджаю",
		index_search_button : "Шукати",
		footer_info : "Дізнатись",
		footer_visit : "Відвідати",
		footer_support : "Підтримка",
		footer_social : "Соціальні мережі",
		footer_info_contact : "Звязатись",
		footer_info_terms : "Умови",
		footer_info_rules : "Правила",
		footer_info_faq : "FAQ",
		footer_info_story : "Історія",
		footer_visit_home : "Головна",
		footer_visit_news : "Новини",
		footer_visit_premium : "Преміум",
		footer_visit_shop : "Магазин",
		footer_visit_forum : "Форум",
		footer_support_center : "Центр",
		footer_support_guides : "Гіди",
		footer_support_tools : "Інструменти",
		footer_support_tutorial : "Туторіали",
		footer_support_webinars : "Вебінари",
		footer_social_facebook : "Facebook",
		footer_social_twitter : "Twitter",
		footer_social_youtube : "YouTube",
		footer_social_pinterest : "Pinterest",
		footer_social_wordpress : "WordPress",
		footer_copyright : "Всі права зарезервовані.",
		
		header_regist_name : "Імя",
		header_regist_surname : "Прізвище",
		header_regist_mail : "Емейл",
		header_regist_pass : "Пароль",
		header_regist_cpass : "Підтвердити пароль",
		header_regist_confirm : "Завершити реєстрацію",
		
		// authorization
		header_error_mail : "Невірна електронна пошта", 
		header_error_mailpass : "Невірний емейл чи пароль",

		// user settings
		// файл не выбран??
		settings_header : " Ваші налаштування",
		settings_header_PERSONAL : "Особиста інформація",
		settings_enter_name : "Імя",
		settings_enter_surname : "Прізвище",
		settings_enter_save : "Зберегти",
		settings_header_pass : "Змінити пароль",
		settings_enter_passnew : "Новий пароль",
		settings_enter_passrepeat : "Повторити новий пароль",
		settings_header_contact : "Контактна інформація",
		settings_enter_phone : "Номер телефону",
		settings_header_manage : "Менеджерська інформація",
		settings_enter_request : "Запит на роль менеджера",


		card_header : "Всього пропозицій ",
		card_no_periodicals : "Наявних  пропозицій немає",
		card_no_hotels : "Готелів не знайдено",

		room_card_count: "Вартість кімнати??",

		subscribes_header : "Список замовлень",
		card_status_active : "Активне",
		subscribes_table_remove : "Видалити замовлення",
		subscribes_empty : "Не знайдено??",
		subscribes_table_name : "Готель",
		subscribes_table_startDate : "В'їзд",
		subscribes_table_endDate: "Виїзд",
		subscribes_table_price: "Ціна",
		subscribes_table_status: "Стан",
		card_status_ended : "Видалено??",
		card_status_removed : "Замовлення відмінено??",

		user_cart_header :"Кошик покупця"
	}
	
	var error = {
		ua: {
			nameLbl: "nameLbl",
			surnameLbl: "surnameLbl",
			emailLbl: "emailLbl",
			passwordLbl: "passwordLbl",
			сpasswordLbl: "сpasswordLbl",
			mailPasswordLbl: "mailPasswordLbl",
			
			header_regist_succes: "header_regist_succes",
			header_regist_confirmmail: "header_regist_confirmmail",
			header_error_fail: "header_error_fail",
			header_regist: "header_regist"
		},
		en: {
			nameLbl: "nameLbl",
			surnameLbl: "surnameLbl",
			emailLbl: "emailLbl",
			passwordLbl: "passwordLbl",
			сpasswordLbl: "сpasswordLbl",
			mailPasswordLbl: "mailPasswordLbl",
			
			header_regist_succes: "header_regist_succes",
			header_regist_confirmmail: "header_regist_confirmmail",
			header_error_fail: "header_error_fail",
			header_regist: "header_regist"
		}
	};
	languages.en = en;
	languages.ua = ua;
	languages.error = error;
	languages.error.current;
})();

function changeLanguage(id, language){
	changeLanguageOnPage(language);
	changeLanguageOnServer(id, language);
}

function changeLanguageOnPage(language){
	for ( var prop in languages) {
		if(prop == language){
			for ( var idElement in languages[prop]){
				$("#" + idElement).html(languages[prop][idElement]);
			}
			break;
		}
	}
}
function changeLanguageOfErrors(language){
	for ( var prop in languages) {
		if(prop == language){
			languages.error.current = languages.error[prop];
			for ( var idElement in languages[prop]){
				$("#" + idElement).html(languages[prop][idElement]);
			}
			break;
		}
	}
}

function changeLanguageOnServer(id, language){
	$.getJSON("http://localhost:7161/booker/language?id=" + id + "&lan=" + language);
	$.getJSON("http://localhost:8080/booker/language?id=" + id + "&lan=" + language);
}

function activeFalseMessage(role, id){
	$.getJSON("http://localhost:7161/task/" + role + "/messageActiveFalse?id=" + id);
	$.getJSON("http://localhost:8080/task/" + role + "/messageActiveFalse?id=" + id);
}