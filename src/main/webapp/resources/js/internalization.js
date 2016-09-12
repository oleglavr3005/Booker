var languages = {};
(function (){
	var en = {
		tab_personal : "Personal",
		tab_contact : "Contacts",
		tab_users : "Users",
		admin_page_id : "ID",
		admin_page_fNane : "First name",
		admin_page_lName : "Last name",
		admin_page_mail : "E-mail",
		admin_page_phone : "Phone",
		admin_page_type : "Type",
		admin_page_status : "Status",
		admin_page_active : "Active",
		admin_page_banned : "Banned",
		admin_page_userId : "User Id",
		admin_page_reqDate : "reqDate &",
		admin_page_message : "Message",
		
		request_approve : "Approve",
		request_decline : "Decline",
		
		manager_hotel_card_info : "Info",
		manager_hotel_card_edit : "Edit",
		manager_hotel_card_removed : "Removed",
		manager_hotel_card_active : "Active",
		
		card_no_hotels : "Active",
		my_feedback_delete : "Delete",
		order_concrete_order_date : "Order date",
		tab_ended : "Ended",
		tab_all : "All",
		tab_active : "Active",
		
		tb_head_id : "ID",
		tb_head_name : "Hotel name",
		tb_head_room : "Room type",
		tb_head_sdate : "Start date",
		tb_head_edate : "End date",
		tb_head_price : "Price",
		tb_head_status : "Status",
		
		shoping_card_shop_list : "Shop list",
		shoping_card_date_asc : "Date asc",
		shoping_card_date_desc : "Date desc",
		shoping_card_price_asc : "Price asc",
		shoping_card_price_desc : "Price desc",
		shopping_cart_modal_header : "Thanks for your order",
		shopping_cart_click : "Go to your order list : ",
		
		room_concret_deleted : "Deleted",
		room_concret_save : "Save",
		room_concret_freebook : "Freebook",
		
		label_wifi : "WiFi",
		label_shower : "Shower",
		label_parking : "Parking",
		label_condition : "Air condition",
		label_pool : "Swiming pool",
		label_gym : "Gym",
		label_balcony : "Balcony",
		 
		header_dropdown_shopping_cart : " Shоpping cart",	
		header_dropdown_orders : " My оrders",
		header_dropdown_feedbacks : " My feedbacks",
		header_dropdown_settings : " Settings",
		header_dropdown_hotels : " My hоtels",
		header_dropdown_admin_stuff : " Admin stuff",
		header_dropdown_log_out: " Lоg оut",
		card_edit : "Edit",
		title_comment_span : "Title", 
		createComment : "Add comment",
		hotel_button_previous : "Previous", 
		hotel_button_next : "Next",
		hiddenError : "Error with info",
		room_card_add_to_cart : "Add to cart", 
		room_card_need_login : "You need login", 
		order_card_from : "From: ",  
		order_card_to : " To: ",
		order_card_order : "Order",
		order_card_total_price : "Total price : ",
		order_card_uan : " UAH",
		order_card_clear : "Clear",
		
		header_regist : "Registration",
		
		header_auth : "Log In",
		header_auth_close : "Close",
		header_auth_forgot : "Forgot password",
		header_auth_enter : "Enter",
		
		index_search_header : "Find Hotel",
		index_search_name : "Destination / Hotel Name:",
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
		settings_chk_mails : "I want receive mails about new rooms!",
		lbl_sendnotif : "Send notif",
		 	
		card_header : "Hotels found",
		card_no_periodicals : "No numbers found",
		card_no_hotels: "No Hotels",
		room_card_count: "Total price?",
		room_card_info1 : "You will get 100% refund in case of cancelling order only in",
		room_card_info2 : " days before moving in, after these period refund will be only",
		room_card_info3 : "Free book",
		subscribes_header : "List of orders",
		card_status_active : "Active",
		subscribes_table_remove : "Cancel",
		subscribes_empty : "Not Found",
		subscribes_table_name : "Hotel",
		subscribes_table_startDate : "Check-in",
		subscribes_table_endDate: "Check-out",
		subscribes_table_price: "Price",
		subscribes_table_status: "Status",
		card_status_ended : "Finished",
		card_status_removed : "Cancelled",

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
		
		
		admin_deleted : "Deleted",
		//admin page
		admin_page_id : "ID",
		admin_page_fName : "fName",
		admin_page_lName : "lName",
		admin_page_mail : "Mail",
		admin_page_phone : "Phone",
		admin_page_type : "Type",
		admin_page_status : "Status",
		admin_page_userId : "userId",
		admin_page_reqDate : "Request date",
		admin_page_message : "Message",
		admin_header : "Admin",
		settings_header_USERS : "Users",
		settings_header_CONTACT : "Contacts",
		
		btn_remove : "Remove",
		btn_order : "Order",
		btn_create : "Create",
		btn_update : "Update",
		btn_create_room : "Create room",
		btn_add_image : "Add image",
		btn_remove_selected : "Remove selected",
		btn_decline : "Decline",
		btn_approve : "Approve",
	}
	var ua = {
		tab_personal : "Особисті налаштування",
		tab_contact : "Контакти",
		tab_users : "Користувачі",
		admin_page_id : "ID",
		admin_page_fNane : "І'мя",
		admin_page_lName : "Прізвище",
		admin_page_mail : "E-mail",
		admin_page_phone : "Телефон",
		admin_page_type : "Тип",
		admin_page_status : "Статус",
		admin_page_active : "Активний",
		admin_page_banned : "Забанений",
		admin_page_userId : "ID користувача",
		admin_page_reqDate : "Дата запиту",
		admin_page_message : "Повідомлення",
			
		request_approve : "Підтвердити",
		request_decline : "Відхилити",
		
		manager_hotel_card_info : "Інформація",
		manager_hotel_card_edit : "Редагувати",
		manager_hotel_card_removed : "Видалений",
		manager_hotel_card_active : "Активний",
		
		card_no_hotels : "Активний",
		my_feedback_delete : "Видалити",
		order_concrete_order_date : "Дата замовлення",
		tab_ended : "Завершенні",
		tab_all : "Всі",
		tab_active : "Активні",
	
		tb_head_id : "ID",
		tb_head_name : "Назва готеля",
		tb_head_room : "Тип кімнати",
		tb_head_sdate : "Початкова дата",
		tb_head_edate : "Кінцева дата",
		tb_head_price : "Ціна",
		tb_head_status : "Статус",

		shoping_card_shop_list : "Список покупок",
		shoping_card_date_asc : "По зростання дати",
		shoping_card_date_desc : "По спаданням дати",
		shoping_card_price_asc : "За зростанням ціни",
		shoping_card_price_desc : "За спаданням ціни",
		shopping_cart_modal_header : "Дякуємо за замовлення",
		shopping_cart_click : "Переглянути список замовлень : ",
			
		room_concret_deleted : "Видалити",
		room_concret_save : "Зберегти",
		room_concret_freebook : "Без передплати",
		
		label_wifi : "WiFi",
		label_shower : "Душ",
		label_parking : "Стоянка",
		label_condition : "Кондиціонер",
		label_pool : "Басейн",
		label_gym : "Тренажерний зал",
		label_balcony : "Балкон",
	
		header_dropdown_shopping_cart: " Кошик",	
		header_dropdown_orders : " Мої покупки",
		header_dropdown_feedbacks : " Мої відгуки",
		header_dropdown_settings : " Налаштування",
		header_dropdown_hotels : " Мої готелі",
		header_dropdown_admin_stuff : " Адміністрування",
		header_dropdown_log_out: " Вийти",
		card_edit : "Редагувати",
		title_comment_span : "Заголовок", 
		createComment : "Додати коментар",
		hotel_button_previous : "Попередній", 
		hotel_button_next : "Наступний",
		hiddenError : "Помилка. Неправильні дані", 
		room_card_add_to_cart : "В кошик", 
		room_card_need_login : "Увійдіть щоб забронювати", 
		order_card_from : "З: ",  
		order_card_to : " До: ",
		order_card_order : "Забронювати",
		order_card_total_price : "Загальна сума : ",
		order_card_uan : " Грн",
		order_card_clear : "Очистити",
			
		index_room_noDeposit : "Без передоплати",
		header_regist : "Реєстрація",
		header_auth : "Увійти",
		header_auth_close : "Закрити",
		header_auth_forgot : "Забули пароль?",
		header_auth_enter : "Увійти",
		
		index_search_header : "Пошук готелів",
		index_search_name : "Місце / назва готелю:",
		index_search_price : "Зірки",
		index_search_ppl : "Кількість гостей",
		index_search_start : "Дата заселення",
		index_search_end : "Дата виселення",
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
		
		hotel_option_star_asc : "За зростанням кількості зірок",
		hotel_option_star_desc : "За спаданням кількості зірок",
		hotel_option_people_asc : "За зростанням кількості людей",
		hotel_option_people_desc : "За спаданням кількості людей",
		
		map_button : "Карта", 
		search : "Пошук",
		
		index_option_star_asc : "За зростанням кількості зірок",
		index_option_star_desc : "За спаданням кількості зірок",
		index_option_rating_asc : "За зростанням рейтингу",
		index_option_rating_desc : "За спаданням рейтингу",	

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
		footer_social_google_plus : "Google +", 
		footer_copyright : "Всі права зарезервовані.",
		
		header_regist_name : "Імя",
		header_regist_surname : "Прізвище",
		header_regist_mail : "E-mail",
		header_regist_pass : "Пароль",
		header_regist_cpass : "Підтвердити пароль",
		header_regist_confirm : "Зареєструватися",
		
		// authorization
		header_author_mail : "E-mail",
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
		settings_chk_mails : "Хочу отримувати повідомлення про нові кімнати!",
		
		lbl_sendnotif : "Посилати повідомлення",
		

		card_header : "Всього пропозицій ",
		card_no_periodicals : "Наявних  пропозицій немає",
		card_no_hotels : "Готелів не знайдено",

		room_card_count: "Вартість кімнати??",
		room_card_info1 : "Ви отримаєте 100% повернення при відміні замовлення тільки за ",
		room_card_info2 : " днів перед приїздом, після цього повернення становитиме тільки ",
		room_card_info3 : "Без передплати",
		
		subscribes_header : "Список замовлень",
		card_status_active : "Активне",
		subscribes_table_remove : "Скасувати",
		subscribes_empty : "Не знайдено",
		subscribes_table_name : "Готель",
		subscribes_table_startDate : "В'їзд",
		subscribes_table_endDate: "Виїзд",
		subscribes_table_price: "Ціна",
		subscribes_table_status: "Стан",
		card_status_ended : "Завершене",
		card_status_removed : "Скасоване",

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
		
		admin_deleted : "Видалити",
		//admin page
		admin_page_id : "ID",
		admin_page_fName : "Імя",
		admin_page_lName : "Прізвище",
		admin_page_mail : "Емейл",
		admin_page_phone : "Телефон",
		admin_page_type : "Тип",
		admin_page_status : "Статус",
		admin_page_userId : "userId",
		admin_page_reqDate : "Дата запиту",
		admin_page_message : "Повідомлення",
		admin_header : "Адмін",
		settings_header_USERS : "Користувачі",
		settings_header_CONTACT : "Контакти",
		
		btn_remove : "Видалити",
		btn_order : "Замовити",
		btn_create : "Створити",
		btn_update : "Змінити",
		btn_create_room : "Створити кімнату",
		btn_add_image : "Додати фото",
		btn_remove_selected : "Видалити обране",
		btn_decline : "Відхилити",
		btn_approve : "Підтвердити",

		header_regist: "Реєстрація",
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
				
			startLbl : "fmtStart",
			endLbl : "fmtEnd",
			pplLbl : "fmtPeople",
			daysLbl : "fmtPeople",
			percentageLbl : "fmtPeople",
			percentageLbl2 : "fmtPeople",
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
			
			tooltip_phone_number : "Номер телефону",
			tooltip_showe_all_info : "Показати всю інформацію",
			tooltip_rating : "Рейтинг",
			tooltip_order_date: "Дата замовлення",
			tooltip_start_date : "Початкова дата",
			tooltip_end_date : "Кінцева дата",
			tooltip_double_beds : "Подвійне ліжко", 
			tooltip_food : "Їжа", 
			tooltip_single_beds : "Одинарне ліжко",
			tooltip_price : "Ціна",
			tooltip_show_info : "Показувати додаткову інфу",
			tooltip_no_deposit : "Без передплати",
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
			
			tooltip_phone_number : "Phone number",
			tooltip_showe_all_info : "Show full info",
			tooltip_rating : "Rating",
			tooltip_order_date: "Order date",
			tooltip_start_date : "Start date",
			tooltip_end_date : "End date",
			tooltip_double_beds : "Double beds", 
			tooltip_food : "Food", 
			tooltip_single_beds : "Single beds",
			tooltip_price : "Price",
			tooltip_show_info : "Show additional info",
			tooltip_no_deposit : "No deposit",
			
		}
	};
	
	languages.en = en;
	languages.ua = ua;
	
	languages.error = error;
	languages.error.current=en;
	
	languages.data_tooltip = data_tooltip;
})();

function changeLanguage(language){
	if(language != 'en' && language != 'ua'){
		language = 'en';
	}
	currentLanguage = language;
	changeLanguageOnPage(language);
	changeLanguageOnServer(language);
}
function updateLanguage(){
	if(currentLanguage != 'en' && currentLanguage != 'ua'){
		currentLanguage = 'en';
	}
	changeLanguageOnPage(currentLanguage);
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
				$("." + idElement).html(languages[prop][idElement]);
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
				$("." + idElement).attr('data-error', languages.error[prop][idElement]);
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
				$("." + idElement).attr('data-tooltip', languages.data_tooltip[prop][idElement]);
			}
			break;
		}
	}
}

function changeLanguageOnServer(language){
	$.getJSON("http://localhost:8080/booker/change_lang?language=" + language);
}
