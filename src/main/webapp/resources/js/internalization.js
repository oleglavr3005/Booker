var languages = {};
(function() {
	var en = {

		feedback_banned : "banned",
		label_service : "Service",
		label_cleaner : "Dry cleaner's",
		comment_user_is_banned : "Banned user can not comment",
		my_feedback_edit : "Save",
		foot_language : "Language",
		roomCard_countOfFree : " available rooms",
		subscribes_table_status_active : "Active",
		subscribes_table_status_finished : "Finished",
		subscribes_table_status_canceled : "Canceled",
		subscribes_table_roomfood_full : "Full",
		subscribes_table_roomfood_twice : "Twice",
		subscribes_table_roomfood_breakfast : "Breakfast",
		subscribes_table_roomfood_none : "None",
		subscribes_table_roomfood : "Food : ",
		subscribes_table_price : "Price",
		subscribes_table_roomtype_standart : "Standart",
		subscribes_table_roomtype_lux : "Lux",
		subscribes_table_roomtype_delux : "Delux",
		orderConcret_title : "Order №",
		order_concret_comment : "Comment",
		myfeedbacks_no_feedbacks : " no feedback",
		myfeedbacks_header : "My feedback",
		server_error : "Internal server error",
		page_not_found : "Page not found",

		comment_not_user : "Log in to post a feedback",
		shopping_card_notice : "Notice: your orders will be stored in the shopping cart only for 30 minutes!",
		tab_charts : "Statistic",
		comment_can_not : "You can not leave feedbacks because you have not been in this hotel.",
		sort_by : "Sort by : ",
		ooltip_you_pay : "You pay a half of the sum for orders with required deposit. Orders with no deposit are free to book",
		feedback_without_feedback : "You have not left any feedbacks",

		tab_personal : "Personal",
		tab_contact : "Contacts",
		tab_manage : "Manager",
		tab_users : "Users",
		tab_ended : "Ended",
		tab_all : "All",
		tab_active : "Active",
		tab_request : "Requests",
		card_edit : "Edit",
		card_no_orders : "Shopping cart is empty",
		// admin page
		admin_edit_name : "Hotel name",
		admin_edit_rating : "Rating",
		admin_edit_address : "Address",
		admin_edit_phone : "Phone number",
		admin_edit_desc : "Description",
		admin_edit_city : "City",
		admin_edit_stars : "Stars",
		admin_header : "Administration",
		admin_page_id : "ID",
		admin_page_fName : "First name",
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
		admin_page_no_email : "No email for this user",
		admin_page_no_phone : "No phone for this user",
		
		admin_table_type_user : "user",
		admin_table_type_manager : "manager",
		admin_table_type_admin : "admin",
		
		admin_deleted : "Delete",

		request_approve : "Approve",
		request_decline : "Decline",
		admin_request_name : "User name",
		admin_request_status : "Request status",
		admin_request_status_pending : "Pending",
		admin_request_status_approved : "Approved",
		admin_request_status_declined : "Declined",

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
		shoping_card_date_asc : "date, ascending",
		shoping_card_date_desc : "date, descending",
		shoping_card_price_asc : "price, ascending",
		shoping_card_price_desc : "price, descending",
		shopping_cart_modal_header : "Thanks for your order",
		shopping_cart_click : "Go to your order list : ",

		room_concret_deleted : "Deleted",
		room_concret_save : "Save",
		room_concret_freebook : "Freebook",
		room_card_add_to_cart : "Add to cart",
		room_card_need_login : "You need login",
		room_card_count : "Total price?",
		room_card_info1 : "You will get 100% refund if you cancel the order at least in",
		room_card_info2 : " days before moving in, after this date the sum will be only",
		room_card_info3 : "Free book",
		room_orderedrooms : "Amount of rooms",
		room_card_YOURE_BANNED : "You cannot make a purchase because you are banned",

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
		header_dropdown_admin_stuff : " Administratiоn",
		header_dropdown_log_out : " Lоg оut",

		title_comment_span : "Title",
		createComment : "Add comment",

		hiddenError : "You must enter start and end date to book rooms.",

		order_card_from : "From: ",
		order_card_to : " To: ",
		order_card_order : "Order",
		order_card_order_all : "Order all",
		order_card_total_price : "Total price : ",
		order_card_uan : " UAH",
		order_card_clear : "Clear cart",

		index_search_header : "Find Hotels",
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
		index_room_type_food : "Food type",
		index_room_type_food_none : "None",
		index_room_type_food_breakfast : "Breakfast",
		index_room_type_food_twice : "Twice",
		index_room_type_food_full : "Full",
		index_room_noDeposit : "No deposit",
		index_option_star_asc : "stars, ascending",
		index_option_star_desc : "stars, descending",
		index_option_rating_asc : "rating, ascending",
		index_option_rating_desc : "rating, descending",
		index_option_people_desc : "people, descending",

		hotel_option_star_asc : "stars, ascending",
		hotel_option_star_desc : "stars, descending",
		hotel_option_people_asc : "people, ascending",
		hotel_option_people_desc : "people, descending",
		hotel_price : "Price",
		hotel_button_previous : "Previous",
		hotel_button_next : "Next",
		hotel_count_room : "Amount of rooms found: ",

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
		settings_header : "Settings",
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
		settings_header_CONTACT : "Contacts",
		settings_enter_phone : "Phone number",
		settings_enter_email : "E-mail address",
		settings_header_manage : "Manager tab",
		settings_enter_request : "Request for manager status",
		settings_save_pass : "Save password",
		settings_chk_mails : "I want to receive e-mail notifications!",
		settings_chk_sms : "I want to receive sms notifications!",
		lbl_sendnotif : "Send out notifications",

		my_hotels_header : "Total hotels",
		card_header : "Hotels found",
		shopping_cart_header : "Amount of goods in the cart",
		card_no_periodicals : "No numbers found",
		card_no_hotels : "No Hotels",

		subscribes_header : "List of orders",
		card_status_active : "Active",
		subscribes_table_remove : "Cancel",
		subscribes_empty : "Not Found",
		subscribes_table_name : "Hotel",
		subscribes_table_startDate : "Check-in",
		subscribes_table_endDate : "Check-out",
		subscribes_table_price : "Price",
		subscribes_table_status : "Status",
		card_status_ended : "Finished",
		card_status_removed : "Cancelled",

		orders_charts_ORDERS_MONTH_CHART : "Orders my month",
		orders_charts_SEASON_CHART : "Popularity by seasons",
		orders_charts_VISITORS : "Visitors",

		user_cart_header : "Shopping Cart",
		orders_charts_HOTELSCHART : "Most visited hotels",
		orders_charts_MONTHCHART : "Monthly activity",
		// hotelList
		room_header : "Rooms",
		room_type : "Room type",
		room_capacity : "Capacity",
		room_conv : "Conveniences",
		room_food : "Food type",
		room_free : "Free book",
		room_deleted : "Deleted",
		room_price : "Price",

		roomCreate_hotel : "In hotel",
		room_concrete_number : "Room numbers splited by commas (Eg: 11, 2a, 3)",
		room_edit_number : "Room number",
		room_concrete_single : "Single beds count",
		room_concrete_double : "Double beds count",
		room_concrete_price : "Price for a night",
		room_concrete_days : "Deadline (days) when user can receive a full money refund",
		room_concrete_percentage : "Return percentage after deadline",

		settings_header_USERS : "Users",
		settings_header_REQUESTS : "Requests",

		btn_remove : "Remove",
		btn_order : "Order",
		btn_create : "Create",
		btn_update : "Update",
		btnToMain : "Set photo as main",
		btn_statistic : "Statistic",
		btn_create_room : "Create room",
		btn_create_hotel : "Create hotel",
		btn_add_image : "Add image",
		btn_remove_selected : "Remove selected",
		btn_decline : "Decline",
		btn_approve : "Approve",
		btn_declined : "Declined",
		btn_approved : "Approved",
		btn_send : "Send"
	}
	var ua = {

		feedback_banned : "забанений",
		label_service : "Обслуговування",
		label_cleaner : "Хімчистка",
		lbl_sendnotif : "Здійснити розсилку",
		comment_user_is_banned : "Забанений користувач не може залишати коментарі",
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
		subscribes_table_roomtype_standart : "Стандарт",
		subscribes_table_roomtype_lux : "Люкс",
		subscribes_table_roomtype_delux : "Делюкс",
		orderConcret_title : "Замовлення №",
		order_concret_comment : "Коментар",
		myfeedbacks_no_feedbacks : " немає відгуків",
		myfeedbacks_header : "Мої відгуки",
		server_error : "Помилка сервера",
		page_not_found : "Сторінку не знайдено",

		comment_not_user : "Ввійдіть, щоб залишити відгук",
		shopping_card_notice : "Увага: ваші замовлення будуть зберігатися в кошику лише протягом 30 хвилин!",
		tab_charts : "Статистика",
		comment_can_not : "Ви не можете залишити відгук, оскільки ще не відвідали цей готель.",
		sort_by : "Сортувати за : ",
		ooltip_you_pay : "Ви сплачуєте половину вартості за номери з обв'язковою передплатою. Номери без передплати можна замовити безкоштовно",
		feedback_without_feedback : "Ви ще не залишили жодного відгуку",

		tab_personal : "Особисті налаштування",
		tab_contact : "Контакти",
		tab_users : "Користувачі",
		tab_manage : "Менеджер",
		tab_request : "Запити",
		admin_page_id : "ID",
		admin_page_fName : "І'мя",
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
		admin_page_no_email : "e-mail відсутній",
		admin_page_no_phone : "Телефон відсутній",
		
		admin_table_type_user : "користувач",
		admin_table_type_manager : "менеджер",
		admin_table_type_admin : "адміністратор",
		
		request_approve : "Підтвердити",
		request_decline : "Відхилити",
		admin_request_name : "Користувач",
		admin_request_status : "Статус запиту",
		admin_request_status_pending : "Очікується",
		admin_request_status_approved : "Схвалено",
		admin_request_status_declined : "Відхилено",

		manager_hotel_card_info : "Деталі",
		manager_hotel_card_edit : "Змінити",
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

		header_dropdown_shopping_cart : " Кошик",
		header_dropdown_orders : " Мої покупки",
		header_dropdown_feedbacks : " Мої відгуки",
		header_dropdown_settings : " Налаштування",
		header_dropdown_hotels : " Мої готелі",
		header_dropdown_admin_stuff : " Адміністрування",
		header_dropdown_log_out : " Вийти",
		card_edit : "Змінити",
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
		room_card_YOURE_BANNED : "Ви не можете здійснювати покупки, бо ви забанені",

		index_room_noDeposit : "Без передоплати",
		header_regist : "Реєстрація",
		header_auth : "Увійти",
		header_auth_close : "Закрити",
		header_auth_forgot : "Забули пароль?",
		header_auth_enter : "Увійти",

		index_search_header : "Пошук готелів",
		index_search_name : "Місце / назва готелю:",
		index_search_price : "Кількість зірок",
		index_search_ppl : "Кількість гостей",
		index_search_start : "Дата заселення",
		index_search_end : "Дата виселення",
		index_search_price_2 : "Ціна",
		index_search_button : "Пошук",

		index_room_type : "Тип кімнати",
		index_room_type_standart : "Стандарт",
		index_room_type_lux : "Люкс",
		index_room_type_delux : "Делюкс",
		index_room_type_food : "Тип харчування",
		index_room_type_food_none : "Немає",
		index_room_type_food_breakfast : "Сніданок",
		index_room_type_food_twice : "Сніданок і вечеря",
		index_room_type_food_full : "Все включено",

		hotel_option_star_asc : "зростанням к-ті зірок",
		hotel_option_star_desc : "спаданням к-ті зірок",
		hotel_option_people_asc : "зростанням к-ті  місць",
		hotel_option_people_desc : "спаданням к-ті  місць",

		map_button : "Карта",
		search : "Пошук",

		index_option_star_asc : "зростанням к-ті  зірок",
		index_option_star_desc : "спаданням к-ті  зірок",
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

		header_regist_name : "І'мя",
		header_regist_surname : "Прізвище",
		header_regist_mail : "E-mail",
		header_regist_pass : "Пароль",
		header_regist_cpass : "Підтвердити пароль",
		header_regist_confirm : "Зареєструватися",

		// authorization
		header_author_mail : "E-mail",
		header_author_pass : "Пароль",
		header_error_mail : "Невірна електронна пошта",
		header_error_mailpass : "Невірний e-mail чи пароль",

		hotel_count_room : "Кількість знайдених кімнат: ",

		// user settings
		// файл не выбран??
		settings_header : "Налаштування",
		settings_header_PERSONAL : "Особиста інформація",
		settings_enter_name : "І'мя",
		settings_enter_surname : "Прізвище",
		settings_enter_save : "Зберегти",
		settings_enter_save1 : "Зберегти",
		settings_header_pass : "Змінити пароль",
		settings_enter_pass : "Старий пароль",
		settings_enter_passnew : "Новий пароль",
		settings_enter_passrepeat : "Повторіть новий пароль",
		settings_header_contact : "Контактна інформація",
		settings_header_CONTACT : "Контактна інформація",
		settings_enter_phone : "Номер телефону",
		settings_enter_email : "E-mail адреса",
		settings_header_manage : "Стати менеджером",
		settings_enter_request : "Запит на роль менеджера",
		settings_save_pass : "Зберегти пароль",
		settings_chk_mails : "Хочу отримувати e-mail сповіщення!",
		settings_chk_sms : "Хочу отримувати sms сповіщення!",

		my_hotels_header : "Загалом моїх готелів",
		card_header : "Всього пропозицій ",
		shopping_cart_header : "Товарів у кошику ",
		card_no_periodicals : "Наявних  пропозицій немає",
		card_no_hotels : "Готелів не знайдено",
		card_no_orders : "Ваш кошик порожній",
		room_card_count : "Вартість кімнати??",
		room_card_info1 : "Вам буде повернено 100% коштів у разі відміни замовлення не пізніше, ніж за ",
		room_card_info2 : "днів до приїзду, після цього сума повернення становитиме лише ",
		room_card_info3 : "Без передплати",
		room_orderedrooms : "Кількість кімнат",

		subscribes_header : "Список замовлень",
		card_status_active : "Активне",
		subscribes_table_remove : "Скасувати",
		subscribes_empty : "Не знайдено",
		subscribes_table_name : "Готель",
		subscribes_table_startDate : "В'їзд",
		subscribes_table_endDate : "Виїзд",
		subscribes_table_price : "Ціна",
		subscribes_table_status : "Стан",
		card_status_ended : "Завершене",
		card_status_removed : "Скасоване",

		orders_charts_ORDERS_MONTH_CHART : "Замовлення по місяцях",
		orders_charts_SEASON_CHART : "Популярність за сезонами",
		orders_charts_VISITORS : "Відвідувачі",

		user_cart_header : "Кошик",
		orders_charts_HOTELSCHART : "Найчастіше відвідувані готелі",
		orders_charts_MONTHCHART : "Активність по місяцях",

		admin_edit_name : "Назва готелю",
		admin_edit_rating : "Рейтинг",
		admin_edit_address : "Адреса",
		admin_edit_phone : "Номер телефону",
		admin_edit_desc : "Опис",
		admin_edit_city : "Місто",
		admin_edit_stars : "Кількість зірок",
		manager_hotel_star : " К-ть зірок : ",

		room_header : "Кімнати",
		room_type : "Тип номера",
		room_capacity : "Місткість",
		room_conv : "Зручності",
		room_food : "Тип харчування",
		room_free : "Без передплати",
		room_deleted : "Видалено",
		room_price : "Ціна",

		roomCreate_hotel : "В готелі",
		room_concrete_number : "Номери кімнат через кому (Напр.: 11, 2a, 3)",
		room_edit_number : "Номер кімнати",
		room_concrete_single : "Кількість одномісних ліжкок",
		room_concrete_double : "Кількість двомісних ліжкок",
		room_concrete_price : "Ціна за добу",
		room_concrete_days : "Крайній термін (днів), коли користувач може отримати повне повернення коштів",
		room_concrete_percentage : "Відсоток повернення завдатку після крайнього терміну",

		admin_deleted : "Видалити",
		// admin page
		admin_page_id : "ID",
		admin_page_fName : "І'мя",
		admin_page_lName : "Прізвище",
		admin_page_mail : "E-mail",
		admin_page_phone : "Телефон",
		admin_page_type : "Тип",
		admin_page_status : "Статус",
		admin_page_userId : "userId",
		admin_page_reqDate : "Дата запиту",
		admin_page_message : "Повідомлення",
		admin_header : "Адміністрування",
		settings_header_USERS : "Користувачі",
		settings_header_REQUESTS : "Запити",

		btn_remove : "Видалити",
		btn_order : "Замовити",
		btn_create : "Створити",
		btn_update : "Змінити",
		btnToMain : "Зробити фото головним",
		btn_statistic : "Статистика",
		btn_create_room : "Створити кімнату",
		btn_create_hotel : "Створити готель",
		btn_add_image : "Додати фото",
		btn_remove_selected : "Видалити обране",
		btn_decline : "Відхилити",
		btn_approve : "Підтвердити",
		btn_declined : "Відхилено",
		btn_approved : "Підтверджено",
		btn_send : "Надіслати",

		header_regist : "Реєстрація",
		aas : "Видалено"
	}
	
//	DATAERROR #############################
	
	var data_error = {
		ua : {
			nameLbl : "Некоректне і'мя",
			surnameLbl : "Некоректне прізвище",
			emailLbl : "Некоректний e-mail",
			passwordLbl : "Некоректний пароль",
			сpasswordLbl : "Непідтверджений пароль",
			mailPasswordLbl : "Некоректний e-mail чи пароль",
			ratingLbl : "Рейтинг від 1 до 5 зірок ",
			addressLbl : "Некоректна адреса",
			phoneLbl : "Некоректний номер телефону",
			descLbl : "Некоректний опис",

			header_regist_succes : "header_regist_succes",
			header_regist_confirmmail : "header_regist_confirmmail",
			header_error_fail : "header_error_fail",
		},
		en : {
			nameLbl : "Invalid first name",
			surnameLbl : "Invalid last name",
			emailLbl : "Invalid email",
			passwordLbl : "Invalid password",
			сpasswordLbl : "Unconfirmed password",
			mailPasswordLbl : "Invalid mail or password",
			ratingLbl : "Rating from 1 to 5 stars ",
			addressLbl : "Invalid address",
			phoneLbl : "Invalid phone number",
			descLbl : "Invalid decription",

			header_regist_succes : "header_regist_succes",
			header_regist_confirmmail : "header_regist_confirmmail",
			header_error_fail : "header_error_fail",

			startLbl : "fmtStart",
			endLbl : "fmtEnd",
			pplLbl : "fmtPeople",
			daysLbl : "fmtPeople",
			percentageLbl : "fmtPeople",
			percentageLbl2 : "fmtPeople",
		}
	};
	
//	DATATOOLTIP #########################
	
	var data_tooltip = {
		ua : {
			index_room_wifi : "Wifi",
			index_room_shower : "Душ",
			index_room_parking : "Стоянка",
			index_room_conditioner : "Кондиціонер",
			index_room_pool : "Басейн",
			index_room_gym : "Тренажерний зал",
			index_room_balcony : "Балкон",
			index_room_cleaner : "Хімчистка",
			index_room_service : "Обслуговування номерів",
			index_room_spa : "Спа",
			index_room_tv : "Телевізор",
			index_search_stars : "Кількість зірок",
			index_search_location : "Розташування",
			index_search_description : "Опис",

			tooltip_phone_number : "Номер телефону",
			tooltip_showe_all_info : "Показати всю інформацію",
			tooltip_rating : "Рейтинг",
			tooltip_order_date : "Дата замовлення",
			tooltip_start_date : "Початкова дата",
			tooltip_end_date : "Кінцева дата",
			tooltip_double_beds : "Кількість подвійних ліжок",
			tooltip_food : "Тип харчування",
			tooltip_single_beds : "Кількість одинарних ліжок",
			tooltip_price : "Ціна за добу",
			tooltip_no_deposit : "Без передплати",
			tooltip_room_type : "Тип номера",
			tooltip_money_to_pay : "Сума оплати",
			tooltip_you_pay : "Загальна сума",
			tooltip_show_info : "Показати додаткову інформацію",
			tooltip_status : "Статус замовлення",
		},
		en : {
			index_room_wifi : "Wifi",
			index_room_shower : "Shower",
			index_room_parking : "Parking",
			index_room_conditioner : "Air conditioner",
			index_room_pool : "Swimming pool",
			index_room_gym : "Fit gym",
			index_room_balcony : "Balcony",
			index_room_cleaner : "Dry cleaner",
			index_room_service : "Room service",
			index_room_spa : "Spa",
			index_room_tv : "Television",
			index_search_stars : "Stars",
			index_search_location : "Location",
			index_search_description : "Description",

			tooltip_phone_number : "Phone number",
			tooltip_showe_all_info : "Show full info",
			tooltip_rating : "Rating",
			tooltip_order_date : "Order date",
			tooltip_start_date : "Start date",
			tooltip_end_date : "End date",
			tooltip_double_beds : "Double beds count",
			tooltip_food : "Food type",
			tooltip_single_beds : "Single beds count",
			tooltip_price : "Price for night",
			tooltip_show_info : "Show additional info",
			tooltip_no_deposit : "No deposit",
			tooltip_room_type : "Room type",
			tooltip_money_to_pay : "Money to pay",
			tooltip_you_pay : "Total sum",
			tooltip_show_info : "Show additional info",
			tooltip_status : "Order status",
		}
	};
	
//	SCRIPT ###########################
	
	var script = {
		en : {
			title : {
				index : 'Booker | Search',
				error404 : 'Booker | Page not found',
				error500 : 'Booker | Internal server error',
				home : 'Booker | Home',
				settings : 'Booker | Settings',
				feedbacks : 'Booker | My feedbacks',
				order : 'Booker | Order',
				orders : 'Booker | My orders',
				cart : 'Booker | Shopping cart',
				hotel_create : 'Booker | New hotel',
				my_hotels : 'Booker | My hotels',
				hotel_orders : 'Booker | Hotel orders',
				new_room : 'Booker | New room',
				room_edit : 'Booker | Room',
				admin : 'Booker | Administration',
				request : 'Booker | Request'
			},
			calendar : {
				min : 'measure create',
				max : 'measure create',
				now : 'now create',
				select : 'parse create validate',
				highlight : 'parse navigate create validate',
				view : 'parse create validate viewset',
				disable : 'deactivate',
				enable : 'activate'
			},
			datepicker : {
				December : 'December',
				Dec : 'Dec',
				January : 'January',
				Jan : 'Jan',
				February : 'February',
				Feb : 'Feb',

				March : 'March',
				Mar : 'Mar',
				April : 'April',
				Apr : 'Apr',
				May : 'May',
				My : 'May',

				June : 'June',
				Jun : 'Jun',
				July : 'July',
				Jul : 'Jul',
				August : 'August',
				Aug : 'Aug',

				September : 'September',
				Sep : 'Sep',
				October : 'October',
				Oct : 'Oct',
				November : 'November',
				Nov : 'Nov',

				Sunday : 'Sunday',
				Sun : 'Sun',
				Monday : 'Monday',
				Mon : 'Mon',
				Tuesday : 'Tuesday',
				Tue : 'Tue',
				Wednesday : 'Wednesday',
				Wed : 'Wed',
				Thursday : 'Thursday',
				Thu : 'Thu',
				Friday : 'Friday',
				Fri : 'Fri',
				Saturday : 'Saturday',
				Sat : 'Sat',

				today : 'Today',
				clear : 'Clear',
				close : 'Close',

				labelMonthNext : 'Next month',
				labelMonthPrev : 'Previous month',
				labelMonthSelect : 'Select a month',
				labelYearSelect : 'Select a year'
			},
			chart : {
				no_hotels : 'No hotels',
				top : 'Top',
				orders : 'Orders count',
				winter : 'Winter',
				spring : 'Spring',
				summer : 'Summer',
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
				removed : "REMOVED!",
				fald : "FAIL",
			},
			registration : {
				wrongMail : "Email is wrong",
				busyMail : "Email is already in use",
				regist : "Registration",
				succes : "Registration success",
				cont : "To complete the registration, use a message with instructions sent on your e-mail",
				fald : "Registration failed",
			},
			message : {
				success : "Success change feedback",
				danger : "Fald change feedback",
			},
			room : {
				createSucces : "room was created",
				createFail : "room cannot be created",
				updateSucces : "room was updated",
				updateFail : "room cannot be updated",
			},
			cart : {
				addSucces : "item was added to cart",
				addFail : "item cannot be added to cart",
				removeSucces : "item was removed from cart",
				removeFail : "item cannot be removed from cart",
				pay : "Pay",
				fail : "Room cannot be booked",
			},
			settings : {
				confMail : "please confirm your new email",
				phnChng : "your new phone number was saved",
				prsnChang : "your data was saved",
				reqSent : "your request was sent to administration",
				reqSentAgain : "your request was sent again",
				reqUpd : "your request was updated",
				reqRmv : "your request was removed",
				pass : "password was changed",
			},
			concrete : {
				succ : "comment was updated",
				fail : "comment cannot be updated",
			},
			request : {
				approved : "request was approved",
				declined : "request was declined",
			},
			admin : {
				activated : "user was activated",
				banned : "user was banned",
			},
			error : {
				func : "function impossible",
			},
			roomfood : {
				full : "Full",
				twice : "Twice",
				breakfast : "Breakfast",
				none : "None",
			},
			roomtype : {
				standart : "Standart",
				lux : "Lux",
				delux : "Delux",
			},
			info : {
				info1 : "You will get 100% refund if you cancel the order at least in",
				info2 : " days before moving in, after this date the sum will be only",
				info3 : "Free book",
			}
		},
		ua : {
			title : {
				index : 'Booker | Пошук',
				error404 : 'Booker | Сторінку не знайдено',
				error500 : 'Booker | Помилка сервера',
				home : 'Booker | Головна',
				settings : 'Booker | Налаштування',
				feedbacks : 'Booker | Мої відгуки',
				order : 'Booker | Замовлення',
				orders : 'Booker | Мої замовлення',
				cart : 'Booker | Кошик',
				hotel_create : 'Booker | Новий готель',
				my_hotels : 'Booker | Мої готелі',
				hotel_orders : 'Booker | Замовлення на готель',
				new_room : 'Booker | Новий номер',
				room_edit : 'Booker | Номер',
				admin : 'Booker | Адміністрування',
				request : 'Booker | Запит'
			},
			calendar : {
				min : 'measure create',
				max : 'measure create',
				now : 'now create',
				select : 'parse create validate',
				highlight : 'parse navigate create validate',
				view : 'parse create validate viewset',
				disable : 'deactivate',
				enable : 'activate'
			},
			datepicker : {
				December : 'Грудень',
				Dec : 'Гру',
				January : 'Січень',
				Jan : 'Січ',
				February : 'Лютий',
				Feb : 'Лют',

				March : 'Березень',
				Mar : 'Бер',
				April : 'Квітень',
				Apr : 'Кві',
				May : 'Травень',
				My : 'Тра',

				June : 'Червень',
				Jun : 'Чер',
				July : 'Липень',
				Jul : 'Лип',
				August : 'Серпень',
				Aug : 'Сер',

				September : 'Вересень',
				Sep : 'Вер',
				October : 'Жовтень',
				Oct : 'Жов',
				November : 'Листопад',
				Nov : 'Лис',

				Sunday : 'Субота',
				Sun : 'Сб',
				Monday : 'Понеділок',
				Mon : 'Пн',
				Tuesday : 'Вівторок',
				Tue : 'Вт',
				Wednesday : 'Середа',
				Wed : 'Ср',
				Thursday : 'Четвер',
				Thu : 'Чт',
				Friday : 'П\'ятниця',
				Fri : 'Пт',
				Saturday : 'Неділя',
				Sat : 'Нд',

				today : 'Зараз',
				clear : 'Відміна',
				close : 'Х',

				labelMonthNext : 'Наступний місяць',
				labelMonthPrev : 'Попередній місяць',
				labelMonthSelect : 'Оберіть місяць',
				labelYearSelect : 'Оберіть рік'
			},
			chart : {
				no_hotels : 'Готелів не знайдено',
				top : 'Топ',
				orders : 'К-ть замовлень',
				winter : 'Зима',
				spring : 'Весна',
				summer : 'Літо',
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
				succes : "Успіх",
				removed : "Скасовано",
				fald : "Помилка",
				makePurchase : "Оплатити",
			},
			registration : {
				wrongMail : "Email адреса не коректна",
				busyMail : "Користувач з такою email адресою вже зареєстрований",
				regist : "Реєстрація",
				succes : "Реєстрація пройшла успішно",
				cont : "Для завершення реєстрації скористайтесь листом, надісланим на вказану e-mail адресу",
				fald : "Помилка реєстрації",
			},
			message : {
				success : "Редагування відгуку пройшло успішно",
				danger : "Помилка редагування відгуку",
			},
			room : {
				createSucces : "кімнату було успішно створено",
				createFail : "кімнату створити не вдалося",
				updateSucces : "кімнату було успішно оновлено",
				updateFail : "кімнату оновити не вдалося",
			},
			cart : {
				addSucces : "предмет було додано до корзини",
				addFail : "предмет додати в корзину не вдалося",
				removeSucces : "предмет було видалено із корзини",
				removeFail : "не вдалося вилучити предмет із корзини",
				pay : "Оплатити",
				fail : "Здійснити покупку не вдалося",
			},
			settings : {
				confMail : "прошу підтвердити вказану пошту",
				phnChng : "Ваш номер телефону було збережено",
				prsnChang : "Ваша інформація була збережена",
				reqSent : "Ваш запит було надіслано на розгляд адміністрації",
				reqSentAgain : "Ваш запит було повторно надіслано на розгляд",
				reqUpd : "Ваш запит було оновлено",
				reqRmv : "Ваш запит було видалено",
				pass : "новий пароль збережено",
			},
			concrete : {
				succ : "коментар було оновлено",
				fail : "коментар оновити не вдалося",
			},
			request : {
				approved : "запит підтверджено",
				declined : "запит відхилено",
			},
			admin : {
				activated : "юзер розбанений",
				banned : "юзер забанений",
			},
			error : {
				func : "дія неможлива",
			},
			roomfood : {
				full : "Все включено",
				twice : "Сніданок і вечеря",
				breakfast : "Сніданок",
				none : "Немає",
			},
			roomtype : {
				standart : "Стандарт",
				lux : "Люкс",
				delux : "Делюкс",
			},
			info : {
				info1 : "Вам буде повернено 100% коштів у разі відміни замовлення не пізніше, ніж за ",
				info2 : "днів до приїзду, після цього сума повернення становитиме лише ",
				info3 : "Без передплати",
			}
		},
	};
	
//	PLACEHOLDER ###########################
	
	var placeholder = {
		en : {
			placeholder_phone_number : "Phone number",
			placeholder_address : "Hotel address",
			placeholder_name_hotel : "Hotel name",
			placeholder_desc : "Description",
			placeholder_enter_comment : "Enter a comment to order here",
			placeholder_enter_comments : "Enter a comment to orders here",
			placeholder_hellopage_search : "Enter a city or a hotel name",
		},
		ua : {
			placeholder_phone_number : "Телефоний номер",
			placeholder_address : "Адреса готелю",
			placeholder_name_hotel : "Назва готелю",
			placeholder_desc : "Опис",
			placeholder_enter_comment : "Введіть коментар до замовленя тут",
			placeholder_enter_comments : "Введіть коментар до всіх замовлень тут",
			placeholder_hellopage_search : "Введіть назву міста чи готелю",
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

function changeLanguage(language) {
	if (language != 'en' && language != 'ua') {
		language = 'en';
	}
	currentLanguage = language;
	languages.script.current = languages.script[currentLanguage];
	$(document).ready(setTimeout('changeLanguageOnPage(currentLanguage)', 200));
	changeLanguageOnServer(language);
}
function updateLanguage() {
	if (currentLanguage != 'en' && currentLanguage != 'ua') {
		currentLanguage = 'en';
	}
	languages.script.current = languages.script[currentLanguage];
	$(document).ready(setTimeout('changeLanguageOnPage(currentLanguage)', 200));
}
function changeLanguageOnPage(language) {
	changeLanguageOnTags(language);
	changeLanguageOfErrors(language);
	changeLanguageOfDataTooltip(language);
	changeLanguageOfDataPlaceholder(language);
	changeLanguageOfDataPagination(language);
	updateDatePicker();
}
function changeLanguageOnTags(language) {
	for ( var prop in languages) {
		if (prop == language) {
			for ( var idElement in languages[prop]) {
				$("#" + idElement).html(languages[prop][idElement]);
				$("." + idElement).html(languages[prop][idElement]);
			}
			break;
		}
	}
}
function changeLanguageOfErrors(language) {
	for ( var prop in languages) {
		if (prop == language) {
			languages.data_error.current = languages.data_error[prop];
			for ( var idElement in languages.data_error[prop]) {
				$("#" + idElement).attr('data-error',
						languages.data_error[prop][idElement]);
				$("." + idElement).attr('data-error',
						languages.data_error[prop][idElement]);
			}
			break;
		}
	}
}
function changeLanguageOfDataTooltip(language) {
	for ( var prop in languages) {
		if (prop == language) {
			for ( var idElement in languages.data_tooltip[prop]) {
				$("#" + idElement).attr('data-tooltip',
						languages.data_tooltip[prop][idElement]);
				$("." + idElement).attr('data-tooltip',
						languages.data_tooltip[prop][idElement]);
			}
			break;
		}
	}
}
function changeLanguageOfDataPlaceholder(language) {
	for ( var prop in languages) {
		if (prop == language) {
			for ( var idElement in languages.placeholder[prop]) {
				$("#" + idElement).attr('placeholder',
						languages.placeholder[prop][idElement]);
				$("." + idElement).attr('placeholder',
						languages.placeholder[prop][idElement]);
			}
			break;
		}
	}
}
function changeLanguageOfDataPagination(language) {
	if (language == 'en') {
		$("#jPag-first").html("First");
		$(".jPag-first").html("First");
		$("#jPag-last").html("Last");
		$(".jPag-last").html("Last");
	}
	if (language == 'ua') {
		$("#jPag-first").html("Перша");
		$(".jPag-first").html("Перша");
		$("#jPag-last").html("Остання");
		$(".jPag-last").html("Остання");
	}
}

function changeLanguageOnServer(language) {
	$.getJSON("http://localhost:8080/booker/change_lang?language=" + language);
}

function updateDatePicker(){
	updateDatePickerMonthS();
	updateDatePickerMonth();
	updateDatePickerWeekday();
	updateDatePickerButton();
}
function updateDatePickerMonthS() {
	mon = $('.picker__month-display div:first');
	var text = mon.text();
	if (currentLanguage == 'en') {
		for ( var ua_mon in languages.script.ua.datepicker) {
			if (languages.script.ua.datepicker[ua_mon] == text) {
				mon.text(languages.script.en.datepicker[ua_mon]);
			}
		}
	}
	if (currentLanguage == 'ua') {
		for ( var en_mon in languages.script.en.datepicker) {
			if (languages.script.en.datepicker[en_mon] == text) {
				mon.text(languages.script.ua.datepicker[en_mon]);
			}
		}
	}
}
function updateDatePickerMonth() {
	mon = document.getElementsByClassName('picker__select--month')[0];
	for(var i = 0 ; i < 12; i++){
		var text = mon.options[1].text;
		if (currentLanguage == 'en') {
			for ( var ua_mon in languages.script.ua.datepicker) {
				if (languages.script.ua.datepicker[ua_mon] == text) {
					mon.options[i].text = languages.script.en.datepicker[ua_mon];
				}
			}
		}
		if (currentLanguage == 'ua') {
			for ( var en_mon in languages.script.en.datepicker) {
				if (languages.script.en.datepicker[en_mon] == text) {
					mon.options[i].text = languages.script.ua.datepicker[en_mon];
				}
			}
		}
	}
}
function updateDatePickerWeekday() {
	mon = $('.picker__weekday-display:first');
	var text = mon.text();
	if (currentLanguage == 'en') {
		for ( var ua_mon in languages.script.ua.datepicker) {
			if (languages.script.ua.datepicker[ua_mon] == text) {
				mon.text(languages.script.en.datepicker[ua_mon]);
			}
		}
	}
	if (currentLanguage == 'ua') {
		for ( var en_mon in languages.script.en.datepicker) {
			if (languages.script.en.datepicker[en_mon] == text) {
				mon.text(languages.script.ua.datepicker[en_mon]);
			}
		}
	}
}
function updateDatePickerButton() {
	var t_todey = $('.picker__today');
	var t_clear = $('.picker__clear');
	var t_close = $('.picker__close');
	t_todey.text(languages.script.current.datepicker.today);
	t_clear.text(languages.script.current.datepicker.clear);
	t_close.text(languages.script.current.datepicker.close);
}