var languages = {};
(function (){
	var en = {
	
		my_feedback_edit : "Save",
		foot_language : "Language",
		roomCard_countOfFree : " free rooms",
		subscribes_table_status_active : "Active",
		subscribes_table_status_finished : "Finished",
		subscribes_table_status_canceled : "Canceled",
		subscribes_table_roomfood_full : "Full",
		subscribes_table_roomfood_twice : "Twice",
		subscribes_table_roomfood_breakfast : "Breakfast",
		subscribes_table_roomfood_none : "None",
		subscribes_table_roomfood : "Food : ",
		subscribes_table_price : "Price",
		subscribes_table_roomtype_standart : "STANDART",
		subscribes_table_roomtype_lux : "LUX",
		subscribes_table_roomtype_delux : "DELUX",
		orderConcret_title : "Order №",
		order_concret_comment : "Comment",
		myfeedbacks_no_feedbacks : " no feedback", 
		myfeedbacks_header : "My feedback",		
			
		comment_not_user : "Log in to post a comment",
		shopping_card_notice : "Notice: your orders will be stored in the shopping cart only for 30 minutes!",
		tab_charts : "Charts",
		comment_can_not : "You can not leave comments as have not stayed in the hotel.",
		sort_by : "Sort by : ",
		ooltip_you_pay : "You pay a half of the sum for orders with deposit. And no money for orders with no deposit",
		feedback_without_feedback : "You have not left a feedback",
		
		tab_personal : "Personal",
		tab_contact : "Contacts",
		tab_manage : "Manager",
		tab_users : "Users",
		tab_ended : "Ended",
		tab_all : "All",
		tab_active : "Active",
		tab_charts : "CHARTS",
		card_edit : "Edit",
		card_no_orders : "Shopping cart is empty",
		//admin page
		admin_edit_name : "Hotel's name",
		admin_edit_rating : "Rating",
		admin_edit_address : "Address",
		admin_edit_phone : "Phone",
		admin_edit_desc : "Description",	
		admin_edit_city : "City",
		admin_edit_stars : "Stars",
		admin_header : "Admin",
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
		admin_page_reqDate : "Request date",
		admin_page_message : "Message",
		admin_deleted : "Deleted",
		
		request_approve : "Approve",
		request_decline : "Decline",
		
		manager_hotel_card_info : "Details",
		manager_hotel_card_edit : "Edit",
		manager_hotel_card_removed : "Removed",
		manager_hotel_card_active : "Active",
		manager_hotel_star : " Stars number : ",
		
		my_feedback_delete : "Delete",
		
		order_concrete_order_date : "Order date",
		
		tb_head_id : "ID",
		tb_head_name : "Hotel name",
		tb_head_room : "Room type",
		tb_head_sdate : "Start date",
		tb_head_edate : "End date",
		tb_head_price : "Price",
		tb_head_status : "Status",
		
		shoping_card_shop_list : "Shop list",
		shoping_card_date_asc : "date, asc",
		shoping_card_date_desc : "date, desc",
		shoping_card_price_asc : "price, asc",
		shoping_card_price_desc : "price, desc",
		shopping_cart_modal_header : "Thanks for your order",
		shopping_cart_click : "Go to your order list : ",
		
		room_concret_deleted : "Deleted",
		room_concret_save : "Save",
		room_concret_freebook : "Freebook",
		room_card_add_to_cart : "Add to cart", 
		room_card_need_login : "You need login", 
		room_card_count: "Total price?",
		room_card_info1 : "You will get 100% refund in case of cancelling order only in",
		room_card_info2 : " days before moving in, after these period refund will be only",
		room_card_info3 : "Free book",
		room_orderedrooms : "Rooms to order",
		
		label_wifi : "WiFi",
		label_shower : "Shower",
		label_parking : "Parking",
		label_condition : "Air condition",
		label_pool : "Swiming pool",
		label_gym : "Gym",
		label_balcony : "Balcony",
		 
		header_regist : "Registration",
		
		header_auth : "Log In",
		header_auth_close : "Close",
		header_auth_forgot : "Forgot password",
		header_auth_enter : "Enter",
		
		header_dropdown_shopping_cart : " Shоpping cart",	
		header_dropdown_orders : " My оrders",
		header_dropdown_feedbacks : " My feedbacks",
		header_dropdown_settings : " Settings",
		header_dropdown_hotels : " My hоtels",
		header_dropdown_admin_stuff : " Admin stuff",
		header_dropdown_log_out: " Lоg оut",
		
		title_comment_span : "Title", 
		createComment : "Add comment",
		
		hiddenError : "You must enter the start and end date for booking rooms.",
		
		order_card_from : "From: ",  
		order_card_to : " To: ",
		order_card_order : "Order",
		order_card_order_all : "Order all",
		order_card_total_price : "Total price : ",
		order_card_uan : " UAH",
		order_card_clear : "Clear cart",
		
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
		index_option_star_asc : "star, asc",
		index_option_star_desc : "star, desc",
		index_option_rating_asc : "rating, asc",
		index_option_rating_desc : "rating, desc",	
		index_option_people_desc : "people, desc",
		
		hotel_option_star_asc : "star, asc",
		hotel_option_star_desc : "star, desc",
		hotel_option_people_asc : "people, asc",
		hotel_option_people_desc : "people, desc ",
		hotel_price : "Price",
		hotel_button_previous : "Previous", 
		hotel_button_next : "Next",
		hotel_count_room : "Number of rooms found: ",
		
		map_button : "Map", 
		search : "Search",

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
		orders_charts_HOTELSCHART : "Most visited hotels",
		orders_charts_MONTHCHART : "Monthly activity",
		//hotelList
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
		room_concrete_percentage: "Deposit return percentage",
		
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
		btn_declined : "Declined",
		btn_approved : "Approved",
		btn_send : "Send",
	}
	var ua = {
			
		my_feedback_edit : "Зберегти",
		foot_language : "Мова",
		roomCard_countOfFree : "Кількість вільних кімнат : ",
		subscribes_table_status_active : "Активний",
		subscribes_table_status_finished : "Завершений",
		subscribes_table_status_canceled : "Відмінений",
		subscribes_table_roomfood_full : "Все включено",
		subscribes_table_roomfood_twice : "Сніданок і вечеря",
		subscribes_table_roomfood_breakfast : "Сніданок",
		subscribes_table_roomfood_none : "Немає",
		subscribes_table_roomfood : "Харчування : ",
		subscribes_table_price : "Ціна",
		subscribes_table_roomtype_standart : "СТАНДАРТ",
		subscribes_table_roomtype_lux : "ЛЮКС",
		subscribes_table_roomtype_delux : "ДЕЛЮКС",
		orderConcret_title : "Замовлення №",
		order_concret_comment : "Коментар",
		myfeedbacks_no_feedbacks : " немає відгуків", 
		myfeedbacks_header : "Мої відгуки",	
			
		comment_not_user : "Ввійдіть, щоб залишити коментар",
		shopping_card_notice : "Увага: ваші замовлення будуть зберігатися в кошику тільки протягом 30 хвилин!",
		tab_charts : "Графіки",
		comment_can_not : "Ви не можете залишити коментар, оскільки ще не відвідали цей готель.",
		sort_by : "Сортувати за : ",
		ooltip_you_pay : "You pay a half of the sum for orders with deposit. And no money for orders with no deposit",
		feedback_without_feedback : "Ви ще не залишили відгуку",	
		
		tab_personal : "Особисті налаштування",
		tab_contact : "Контакти",
		tab_users : "Користувачі",
		tab_manage : "Менеджер",
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
		
		manager_hotel_card_info : "Деталі",
		manager_hotel_card_edit : "Редагувати",
		manager_hotel_card_removed : "Видалений",
		manager_hotel_card_active : "Активний",
		
		my_feedback_delete : "Видалити",
		order_concrete_order_date : "Дата замовлення",
		tab_ended : "Завершені",
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
		shoping_card_date_asc : "зростанням дати",
		shoping_card_date_desc : "спаданням дати",
		shoping_card_price_asc : "зростанням ціни",
		shoping_card_price_desc : "спаданням ціни",
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
		hiddenError : "Необхідно ввести початкову і кінцеву дату для бронювання кімнати.", 
		room_card_add_to_cart : "В кошик", 
		room_card_need_login : "Увійдіть щоб забронювати", 
		order_card_from : "З: ",  
		order_card_to : " До: ",
		order_card_order : "Забронювати",
		order_card_order_all : "Забронювати всі",
		order_card_total_price : "Загальна сума : ",
		order_card_uan : " Грн",
		order_card_clear : "Очистити кошик",
			
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
		
		hotel_option_star_asc : "зростанням к-сті зірок",
		hotel_option_star_desc : "спаданням к-сті зірок",
		hotel_option_people_asc : "зростанням к-сті  місць",
		hotel_option_people_desc : "спаданням к-сті  місць",
		
		map_button : "Карта", 
		search : "Пошук",
		
		index_option_star_asc : "зростанням к-сті  зірок",
		index_option_star_desc : "спаданням к-сті  зірок",
		index_option_rating_asc : "зростанням рейтингу",
		index_option_rating_desc : "спаданням рейтингу",	

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
		card_no_orders : "Ваш кошик порожній",
		room_card_count: "Вартість кімнати??",
		room_card_info1 : "Ви отримаєте 100% повернення при відміні замовлення тільки за ",
		room_card_info2 : "гів перед приїздом, після цього повернення становитиме тільки ",
		room_card_info3 : "Без передплати",
		room_orderedrooms : "Замовити кімнат",
		
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

		user_cart_header :"Кошик",
		orders_charts_HOTELSCHART : "Найчастіше відвідувані готелі",
		orders_charts_MONTHCHART : "Щомісячна активність",
		
		admin_edit_name : "Назва готелю",
		admin_edit_rating : "Рейтинг",
		admin_edit_address : "Адреса",
		admin_edit_phone : "Телефон",
		admin_edit_desc : "Опис",
		admin_edit_city : "Місто",
		admin_edit_stars : "Зірки",
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
		room_concrete_percentage: "Відсоток повернення завдатку",
		
		admin_deleted : "Видалити",
		//admin page
		admin_page_id : "ID",
		admin_page_fName : "Імя",
		admin_page_lName : "Прізвище",
		admin_page_mail : "E-mail",
		admin_page_phone : "Телефон",
		admin_page_type : "Тип",
		admin_page_status : "Статус",
		admin_page_userId : "userId",
		admin_page_reqDate : "Дата запиту",
		admin_page_message : "Повідомлення",
		admin_header : "Адміністратор",
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
		btn_declined : "Відхилено",
		btn_approved : "Підтверджено",
		btn_send : "Надіслати",

		header_regist: "Реєстрація",
	}
	var data_error = {
		ua: {
			nameLbl: "Некоректне імя",
			surnameLbl: "Некоректне прізвище",
			emailLbl: "Некоректний емейл",
			passwordLbl: "Некоректний пароль",
			сpasswordLbl: "Непідтверджений пароль",
			mailPasswordLbl: "Некоректний емейл чи пароль",
			ratingLbl : "Рейтинг від 1 до 5 зірок ",
			addressLbl : "Некоректна адреса",
			phoneLbl : "Некоректний номер телефону",
			descLbl : "Некоректний опис",
			
			header_regist_succes: "header_regist_succes",
			header_regist_confirmmail: "header_regist_confirmmail",
			header_error_fail: "header_error_fail",
		},
		en: {
			nameLbl: "Invalid first name",
			surnameLbl: "Invalid last name",
			emailLbl: "Invalid email",
			passwordLbl: "Invalid password",
			сpasswordLbl: "Unconfirmed password",
			mailPasswordLbl: "Invalid mail or password",
			ratingLbl : "Rating from 1 to 5 stars ",
			addressLbl : "Invalid address",
			phoneLbl : "Invalid phone number",
			descLbl : "Invalid decription",
			
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
			tooltip_room_type : "Тип номера",
			tooltip_money_to_pay : "Оплатити",
			tooltip_you_pay : "Загальна сума",
			tooltip_show_info : "Показати додаткову інформацію",
		},
		en : {
			index_room_wifi : "Wifi",
			index_room_shower : "Shower",
			index_room_parking : "Parking",
			index_room_conditioner : "Air conditioner",
			index_room_pool : "Swimming pool",
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
			tooltip_room_type : "Room's type",
			tooltip_money_to_pay : "Money to pay",
			tooltip_you_pay : "Total sum",
			tooltip_show_info : "Show additional info",
		}
	};
	var script = {
		en : {
			calendar : {
				min: 'measure create',
		        max: 'measure create',
		        now: 'now create',
		        select: 'parse create validate',
		        highlight: 'parse navigate create validate',
		        view: 'parse create validate viewset',
		        disable: 'deactivate',
		        enable: 'activate'
		    },
		    datepicker : {
		    	December : 'December', Dec : 'Dec',
		    	January : 'January', Jan : 'Jan',
		    	February : 'February', Feb : 'Feb',

		    	March : 'March', Mar : 'Mar',
		    	April : 'April', Apr : 'Apr',
		    	May : 'May', My : 'May',

		    	June : 'June', Jun : 'Jun',
		    	July : 'July', Jul : 'Jul',
		    	August : 'August', Aug : 'Aug',

		    	September : 'September', Sep : 'Sep',
		    	October : 'October', Oct : 'Oct',
		    	November : 'November', Nov : 'Nov',
		    	
		    	Sunday : 'Sunday', Sun : 'Sun',
		    	Monday : 'Monday', Mon : 'Mon',
		    	Tuesday : 'Tuesday', Tue : 'Tue',
		    	Wednesday : 'Wednesday', Wed : 'Wed',
		    	Thursday : 'Thursday', Thu : 'Thu',
		    	Friday : 'Friday', Fri : 'Fri',
		    	Saturday : 'Saturday', Sat : 'Sat',
		    	
		    	today: 'Today',
				clear: 'Clear',
				close: 'Close',
				
				labelMonthNext: 'Next month',
				labelMonthPrev: 'Previous month',
				labelMonthSelect: 'Select a month',
				labelYearSelect: 'Select a year'
		    },
		    chart : {
		    	no_hotels : 'No hotels',
		    	top: 'Top',
		    	orders : 'Orders count',
		    	winter : 'Winter',
		    	spring: 'Spring',
		    	summer: 'Summer',
		    	autumn : 'Autumn',
		    	visitors : 'Visitors count',
		    	first_month : 'First month',
		    	second_month : 'Second month',
		    	third_month : 'Third month'
		    },
		    message_error : 'Can not add comment',
		    info_toggle_open : 'Show additional info',
		    info_toggle_hide : 'Hide additional info',
		    first : "First",
		    last : "Last",
		    hotel : {
		    	createSucces : "hotel was created",
		    	createFail : "hotel wasnt created",
		    	updateSucces : "hotel was updated",
		    	updateFail : "hotel wasnt updated",
		    	wrongData : "INVALID DATA",
		    	numberBusy : "this number is allready in use",
		    	is_max : " is max",
		    	enter_key : "Enter Keywords Here",
		    	rows_per_page : "Rows per page:",
		    	sInfo : "_START_ -_END_ of _TOTAL_",
		    }, 
		    createOrder : { 
		    	error : "ERROR OCCURED",
		    	cvvError : "Card number is wrong",
		    	cardError : "Card number is wrong",
		    	succes : "SUCCES",
		    	removed : "REMOVED",
		    	fald : "FAIL",
		    }, 
		    registration : {
		    	wrongMail : "Email is wrong",
		    	busyMail : "Email is allready in use",
		    	regist : "Registration",
		    	succes : "Registration succes",
		    	cont : "To complete the registration, go to the specified e-mail",
		    	fald : "Registration fald",
		    }, 
		    settings : {
		    	succesTitle : "SUCCESFULLY CHANGED PASSWORD",
		    	oldHeader : "OLD HEADER TEXT INSERT HERE",
		    },
		    message : {
		    	success : "Success change feedback",
		    	danger : "Fald change feedback",
		    }
		},
		ua : {
			calendar : {
				min: 'measure create',
		        max: 'measure create',
		        now: 'now create',
		        select: 'parse create validate',
		        highlight: 'parse navigate create validate',
		        view: 'parse create validate viewset',
		        disable: 'deactivate',
		        enable: 'activate'
		    },
		    datepicker : {
		    	December : 'Грудень', Dec : 'Гру',
		    	January : 'Січень', Jan : 'Січ',
		    	February : 'Лютий', Feb : 'Лют',

		    	March : 'Березень', Mar : 'Бер',
		    	April : 'Квітень', Apr : 'Кві',
		    	May : 'Травень', My : 'Тра',

		    	June : 'Червень', Jun : 'Чер',
		    	July : 'Липень', Jul : 'Лип',
		    	August : 'Серпень', Aug : 'Сер',

		    	September : 'Вересень', Sep : 'Вер',
		    	October : 'Жовтень', Oct : 'Жов',
		    	November : 'Листопад', Nov : 'Лис',
		    	
		    	Sunday : 'Субота', Sun : 'Сб',
		    	Monday : 'Понеділок', Mon : 'Пн',
		    	Tuesday : 'Вівторок', Tue : 'Вт',
		    	Wednesday : 'Середа', Wed : 'Ср',
		    	Thursday : 'Четвер', Thu : 'Чт',
		    	Friday : 'П\'ятниця', Fri : 'Пт',
		    	Saturday : 'Неділя', Sat : 'Нд',
		    	
		    	today: 'Зараз',
				clear: 'Відміна',
				close: 'Х',
				
				labelMonthNext: 'Наступний місяць',
				labelMonthPrev: 'Попередній місяць',
				labelMonthSelect: 'Оберіть місяць',
				labelYearSelect: 'Оберіть рік'
		    },
		    chart : {
		    	no_hotels : 'Готелів не знайдено',
		    	top: 'Топ',
		    	orders : 'К-ть замовлень',
		    	winter : 'Зима',
		    	spring: 'Весна',
		    	summer: 'Літо',
		    	autumn : 'Осінь',
		    	visitors : 'К-ть відвідувачів',
		    	first_month : 'Перший місяць',
		    	second_month : 'Другий місяць',
		    	third_month : 'Третій місяць'
		    },
		    message_error : 'Неможли додати коментар',
		    info_toggle_open : 'Показати додаткову інформацію',
		    info_toggle_hide : 'Сховати додаткову інформацію',
		    first : "Перша",
		    last : "Остання",
		    hotel : {
		    	createSucces : "Готель створений",
		    	createFail : "Готель не був створений",
		    	updateSucces : "Готель оновлений",
		    	updateFail : "Готель не був оновлений",
		    	wrongData : "Невалідні дані",
		    	numberBusy : "Це число вже використовуєтся",
		    	is_max : " максимум",
		    	enter_key : "Введіть ключові слова",
		    	rows_per_page : "Рядків на сторінку:",
		    	sInfo : "_ПОЧАТОК_ -_КІНЕЦЬ_ з _ВСЬОГО_",
		    }, 
		    createOrder : { 
		    	error : "ПОМИЛКА",
		    	cvvError : "Номер карточки не коректний",
		    	cardError : "Номер карточки не коректний",
		    	succes : "УСПІШНО",
		    	removed : "ВИДАЛЕНИЙ ???",
		    	fald : "Помилка",
		    	makePurchase : "Оплатити",
		    }, 
		    registration : {
		    	wrongMail : "Email не коректний",
		    	busyMail : "Користувач з таким email вже зареєстрований",
		    	regist : "Реєстрація",
		    	succes : "Реєстрація пройшла успішно",
		    	cont : "Для завершення реєстрації перейділь на вказаний e-mail",
		    	fald : "Помилка реєстрації",
		    }, 
		    settings : {
		    	succesTitle : "Успішна зміна пароля",
		    	oldHeader : "OLD HEADER TEXT INSERT HERE ???",
		    },
		    message : {
		    	success : "Редагування відгуку пройшло успішно",
		    	danger : "Помилка редагування відгуку",
		    }
		},
	};
	var placeholder = {
		en : {
			placeholder_phone_number : "Phone Number",
			placeholder_address : "Address of hotel",
			placeholder_name_hotel : "Name of Hotel",
			placeholder_desc : "Description",
			placeholder_enter_comment : "Enter comment to order here",
			placeholder_enter_comments : "Enter comment to orders here",
			placeholder_hellopage_search : "Enter city or hotel",
		},
		ua : {
			placeholder_phone_number : "Телефоний номер",
			placeholder_address : "Адреса готеля",
			placeholder_name_hotel : "Назва готеля",
			placeholder_desc : "Опис",
			placeholder_enter_comment : "Введіть коментар до замовленя тут",
			placeholder_enter_comments : "Введіть коментар до всіх замовлень тут",
			placeholder_hellopage_search : "Введіть місто чи готель",
		},
	};
	languages.en = en;
	languages.ua = ua;
	languages.data_error = data_error;
	languages.data_error.current = data_error.en;
	languages.data_tooltip = data_tooltip;
	languages.script = script;
	languages.script.current = script.en;
	languages.placeholder = placeholder;
})();

function changeLanguage(language){
	if(language != 'en' && language != 'ua'){
		language = 'en';
	}
	currentLanguage = language;
	languages.script.current = languages.script[currentLanguage];
	$(document).ready(setTimeout('changeLanguageOnPage(currentLanguage)' , 200));
	changeLanguageOnServer(language);
}
function updateLanguage(){
	if(currentLanguage != 'en' && currentLanguage != 'ua'){
		currentLanguage = 'en';
	}
	languages.script.current = languages.script[currentLanguage];
	$(document).ready(setTimeout('changeLanguageOnPage(currentLanguage)' , 200));
}
function changeLanguageOnPage(language){
	changeLanguageOnTags(language);
	changeLanguageOfErrors(language);
	changeLanguageOfDataTooltip(language);
	changeLanguageOfDataPlaceholder(language);
	changeLanguageOfDataPagination(language);
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
			languages.data_error.current = languages.data_error[prop];
			for ( var idElement in languages.data_error[prop]){
				$("#" + idElement).attr('data-error', languages.data_error[prop][idElement]);
				$("." + idElement).attr('data-error', languages.data_error[prop][idElement]);
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
function changeLanguageOfDataPlaceholder(language){
	for ( var prop in languages) {
		if(prop == language){
			for ( var idElement in languages.placeholder[prop]){
				$("#" + idElement).attr('placeholder', languages.placeholder[prop][idElement]);
				$("." + idElement).attr('placeholder', languages.placeholder[prop][idElement]);
			}
			break;
		}
	}
}
function changeLanguageOfDataPagination(language){
	if(language == 'en'){
		$("#jPag-first").html("First");
		$(".jPag-first").html("First");
		$("#jPag-last").html("Last");
		$(".jPag-last").html("Last");
	}
	if(language == 'ua'){
		$("#jPag-first").html("Перша");
		$(".jPag-first").html("Перша");
		$("#jPag-last").html("Остання");
		$(".jPag-last").html("Остання");
	}
}

function changeLanguageOnServer(language){
	$.getJSON("http://localhost:8080/booker/change_lang?language=" + language);
}
