var languages = {};
(function (){
	var en = {
		tab_contact : "CONTACT",
		tab_users : "USERS",
		admin_page_id : "ID",
		admin_page_fNane : "fNane",
		admin_page_lName : "lName",
		admin_page_mail : "Mail",
		admin_page_phone : "Phone",
		admin_page_type : "Type",
		admin_page_status : "Status",
		admin_page_active : "ACTIVE",
		admin_page_banned : "BANNED",
		admin_page_userId : "userId",
		admin_page_reqDate : "reqDate",
		admin_page_message : "Message",
		
		request_approve : "APPROVE",
		request_decline : "DECLINE",
		
		manager_hotel_card_info : "INFO",
		manager_hotel_card_edit : "EDIT",
		manager_hotel_card_removed : "REMOVED",
		manager_hotel_card_active : "ACTIVE",
		
		card_no_hotels : "ACTIVE",
		
		
			
		header_dropdown_shopping_cart : " Shоpping cart",	
		header_dropdown_orders : " My оrders",
		header_dropdown_feedbacks : " My feedbacks",
		header_dropdown_settings : " Settings",
		header_dropdown_hotels : " My hоtels",
		header_dropdown_admin_stuff : " Admin stuff",
		header_dropdown_log_out: " Lоg оut",
		card_edit : "EDIT",
		title_comment_span : "Title", 
		createComment : "Add comment",
		hotel_button_previous : "Previous", 
		hotel_button_next : "Next",
		hiddenError : "ERROR WITH INFO", 
		room_card_add_to_cart : "ADD TO CART", 
		room_card_need_login : "U NEED 2 LOGIN", 
		order_card_from : "From: ",  
		order_card_to : " To: ",
		order_card_order : "ORDER",
		order_card_total_price : "TOTAL_PRICE : ",
		order_card_uan : " UAH",
		order_card_clear : "CLEAR",
		
		header_regist : "Registration",
		
		header_auth : "Log In",
		header_auth_close : "Close",
		header_auth_forgot : "Forgot password",
		header_auth_enter : "Enter",
		
		index_search_header : "Find Hotel",
		index_search_name : "Destination/Hotel Name:",
		index_search_start : "Start date",
		index_search_end : "End date",
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
		
		index_room_noDeposit : "No deposit",
		hotel_option_star_asc : "Star asc",
		hotel_option_star_desc : "Star desc",
		hotel_option_people_asc : "People asc",
		hotel_option_people_desc : "People desc",
		hotel_price : "Price",

		map_button : "Map", 
		search : "Search",

		index_option_star_asc : "Star asc",
		index_option_star_desc : "Star desc",
		index_option_rating_asc : "Rating asc",
		index_option_rating_desc : "Rating desc",	
		
		index_option_people_desc : "People desc",

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
		header_regist_cpass : "Confirm password",
		header_regist_confirm : "Finish",
		
		hotel_count_room : "Number of rooms found: ",
		
		// authorization
		header_author_mail : "Email",
		header_author_pass : "Password",
		header_error_mail : "Invalid email",
		header_error_mailpass : "Invalid email or password",
		
		// user settings
		settings_header : " Your settings",
		settings_header_PERSONAL : "Personal information",
		settings_enter_name : "First name",
		settings_enter_surname : "Last name ",
		settings_enter_save : "Save",
		settings_enter_save1 : "Save",
		settings_enter_pass : "Old password",
		settings_header_pass : "Change password",
		settings_enter_passnew : " New password",
		settings_enter_passrepeat : "Repeat new password",
		settings_header_contact : "Contacts",
		settings_enter_phone : "Phone number",
		settings_header_manage : "Manager",
		settings_enter_request : "Request for manager",
		settings_save_pass : "Save password",
			
		card_header : "Hotels found",
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

		user_cart_header :"Shopping Cart",
		
		//hotelList
		admin_edit_name : "Hotel's name",
		admin_edit_rating : "Rating",
		admin_edit_address : "Address",
		admin_edit_phone : "Phone",
		admin_edit_desc : "Description",	
		admin_edit_city : "City",
		manager_hotel_star : " Stars number : ",
		
		room_header : "Rooms",
		room_type: "Type", 
		room_capacity : "Capacity",
		room_conv: "Conveniences",				
		room_food:"Food",
		room_free: "Free Book",
		room_deleted: "Deleted",						
		room_price: "Price",
		
		roomCreate_hotel : "In hotel",
		room_concrete_number : "Number",
		room_concrete_single : "Single beds",
		room_concrete_double : "Double beds",
		room_concrete_price : "Price",
		room_concrete_days : "Days before to pay",
		room_concrete_percentage: "Deposit percentage",
		
		
		admin_deleted : "DELETED",
		btn_remove : "REMOVE",
		btn_order : "ORDER",
		btn_create : "CREATE",
		btn_update : "UPDATE",
		btn_create_room : "CREATE ROOM",
		btn_add_image : "ADD IMAGE",
		btn_remove : "REMOVE SELECTED",
	}
	var ua = {
		header_dropdown_shopping_cart: "Кошик",	
		header_dropdown_orders : "Мої покупки",
		header_dropdown_feedbacks : "Мої відгуки",
		header_dropdown_settings : "Налаштування",
		header_dropdown_hotels : "Мої готелі",
		header_dropdown_admin_stuff : "Адміністрування",
		header_dropdown_log_out: "Вийти",
		card_edit : "Редагувати",
		title_comment_span : "Заголовок", 
		createComment : "Додати коментар",
		hotel_button_previous : "Попередній", 
		hotel_button_next : "Наступний",
		hiddenError : "Помилка. Неправильні дані", 
		room_card_add_to_cart : "Додати до картки", 
		room_card_need_login : "Увійдіть щоб забронювати", 
		order_card_from : "З: ",  
		order_card_to : " До: ",
		order_card_order : "Забронювати",
		order_card_total_price : "Загальна сума : ",
		order_card_uan : " Грн",
		order_card_clear : "Очистити",
			
			
		header_regist : "Реєстрація",
		header_auth : "Увійти",
		header_auth_close : "Закрити",
		header_auth_forgot : "Забули пароль?",
		header_auth_enter : "Увійти",
		
		index_search_header : "Шукати готель",
		index_search_name : "Місце/назва готелю:",
		index_search_price : "Зірки",
		index_search_ppl : "Кількість гостей",
		index_search_start : "Приїжджаю",
		index_search_end : "Від'їжджаю",
		index_search_price_2 : "Ціна",
		index_search_button : "Пошук",
		
		index_room_type : "Тип кімнати",
		index_room_type_standart : "Стандарт",
		index_room_type_lux : "Люкс",
		index_room_type_delux : "Делюкс",
		index_room_type_food : "Харчування",
		index_room_type_food_none : "Немає",
		index_room_type_food_breakfast : "Сніданок",
		index_room_type_food_twice: "Сніданок і вечеря",
		index_room_type_food_full: "Все включено",
				
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
		header_author_mail : "Емейл",
		header_author_pass : "Пароль",
		header_error_mail : "Невірна електронна пошта", 
		header_error_mailpass : "Невірний емейл чи пароль",
		
		hotel_count_room : "Кількість знайдених кімнат: ",

		// user settings
		// файл не выбран??
		settings_header : " Ваші налаштування",
		settings_header_PERSONAL : "Особиста інформація",
		settings_enter_name : "Імя",
		settings_enter_surname : "Прізвище",
		settings_enter_save : "Зберегти",
		settings_enter_save1 : "Зберегти",
		settings_header_pass : "Змінити пароль",
		settings_enter_pass : "Старий пароль",
		settings_enter_passnew : "Новий пароль",
		settings_enter_passrepeat : "Повторити новий пароль",
		settings_header_contact : "Контактна інформація",
		settings_enter_phone : "Номер телефону",
		settings_header_manage : "Менеджерська інформація",
		settings_enter_request : "Запит на роль менеджера",
		settings_save_pass : "Зберегти пароль",

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

		user_cart_header :"Кошик покупця",
		
		admin_edit_name : "Назва готелю",
		admin_edit_rating : "Рейтинг",
		admin_edit_address : "Адреса",
		admin_edit_phone : "Телефон",
		admin_edit_desc : "Опис",
		admin_edit_city : "Місто",
		manager_hotel_star : " К-сть зірок : ",
		
		room_header : "Кімнати",
		room_type: "Тип", 
		room_capacity : "Місткість",
		room_conv: "Зручності",				
		room_food:"Харчування",
		room_free: "Без передплати",
		room_deleted: "Видалено",						
		room_price: "Ціна",
		
		roomCreate_hotel : "В готелі",
		room_concrete_number : "Номер",
		room_concrete_single : "Одномісні ліжка",
		room_concrete_double : "Двомісні ліжка",
		room_concrete_price : "Ціна",
		room_concrete_days : "Дні для оплати",
		room_concrete_percentage: "Відсоток завдатку",
		
		admin_deleted : "ВИДАЛЕНО",
		btn_remove : "ВИДАЛИТИ",
		btn_order : "ЗАМОВИТИ",
		btn_create : "СТВОРИТИ",
		btn_update : "ЗМІНИТИ",
		btn_create_room : "СТВОРИТИ КІМНАТУ",
		btn_add_image : "ДОДАТИ ФОТО",
		btn_remove : "ВИДАЛИТИ ОБРАНЕ",
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
			header_regist: "header_regist",
				
			startLbl : "fmtStart",
			endLbl : "fmtEnd",
			pplLbl : "fmtPeople",
		}
	};
	var data_tooltip = {
		ua : {
			index_room_wifi : "Wifi",
			index_room_shower : "Душ",
			index_room_parking : "Стоянка",
			index_room_conditioner : "Кондиціонер",
			index_room_pool : "Басейн",
			index_room_gym : "Тренажерний зал",
			index_room_balcony : "Балкон",
			index_search_stars : "Зірки",
			index_search_location : "Розташування",
			index_search_description : "Опис",
		},
		en : {
			index_room_wifi : "Wifi",
			index_room_shower : "Shower",
			index_room_parking : "Parking",
			index_room_conditioner : "Air conditioner",
			index_room_pool : "Swiming pool",
			index_room_gym : "Fit gym",
			index_room_balcony : "Balcony",
			index_search_stars : "Stars",
			index_search_location : "Location",
			index_search_description : "Description",
		}
	};
	
	languages.en = en;
	languages.ua = ua;
	
	languages.error = error;
	languages.error.current=en;
	
	languages.data_tooltip = data_tooltip;
})();

function changeLanguage(id, language){
	changeLanguageOnPage(language);
	changeLanguageOnServer(id, language);
}

function changeLanguageOnPage(language){
	changeLanguageOnTags(language);
	changeLanguageOfErrors(language);
	changeLanguageOfDataTooltip(language);
}
function changeLanguageOnTags(language){
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
			for ( var idElement in languages.error[prop]){
				$("#" + idElement).attr('data-error', languages.error[prop][idElement]);
			}
			break;
		}
	}
}

function changeLanguageOfDataTooltip(language){
	for ( var prop in languages) {
		if(prop == language){
			for ( var idElement in languages.data_tooltip[prop]){
				$("#" + idElement).attr('data-tooltip', languages.data_tooltip[prop][idElement]);
			}
			break;
		}
	}
}

function changeLanguageOnServer(id, language){
	$.getJSON("http://localhost:8080/booker/change_lang?language=" + language);
}
