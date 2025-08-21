insert into AUTHORITIES(AUTHORITY)
values ( 'FULL'), ('WRITE_ONLY');

insert into roles(role_name, authority_id)
values ('ADMIN', (select id from authorities where authority = 'FULL')),
       ('USER', (select id from authorities where authority = 'WRITE_ONLY'));

INSERT INTO users (name, surname, age, email, password, phone_number, avatar, account_type, enabled, role_id)
VALUES ('Асан', 'Токтосунов', 25, 'asan@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0500123456', 'avatar1.png', 'admin', true, (SELECT id FROM roles WHERE role_name = 'ADMIN')),
       ('Улан', 'Маматов', 30, 'ulan@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0500234567', 'avatar2.png', 'applicant', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Алишер', 'Борбиев', 30, 'alisher@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0500123456', 'avatar2.png', 'applicant', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Айгерим', 'Токтошева', 25, 'aigerim@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0700765432', 'avatar3.png', 'applicant', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Нурлан', 'Жунусов', 28, 'nurlan@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0550345678', 'avatar4.png', 'applicant', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Динара', 'Султанова', 32, 'dinara@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0770987654', 'avatar5.png', 'applicant', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Азиз', 'Асанов', 27, 'aziz@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0700234567', 'avatar6.png', 'applicant', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Айдана', 'Бекова', 24, 'aidana@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0550654321', 'avatar7.png', 'applicant', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Бек', 'Сатаров', 29, 'bek@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0500765432', 'avatar8.png', 'applicant', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Жанна', 'Мырзаханова', 31, 'zhanna@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0770345678', 'avatar9.png', 'applicant', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Тилек', 'Сатыбалдиев', 26, 'tilek@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0700987654', 'avatar10.png', 'applicant', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Гульнур', 'Абдыкадырова', 23, 'gulnur@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0550123456', 'avatar11.png', 'applicant', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Данияр', 'Жолдошов', 35, 'daniyar@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0500987123', 'avatar12.png', 'applicant', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Сания', 'Токтомамбетова', 28, 'sania@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0700543210', 'avatar13.png', 'applicant', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Марат', 'Кайратов', 31, 'marar@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0550765432', 'avatar14.png', 'applicant', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Ляззат', 'Кожомкулова', 29, 'lazzat29@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0770345670', 'avatar15.png', 'applicant', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Эрмек', 'Сариев', 27, 'ermek@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0700123498', 'avatar16.png', 'employer', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Нургуль', 'Бекматова', 25, 'nurgul@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0550654320', 'avatar17.png', 'employer', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Камил', 'Токтогулов', 33, 'kamil@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0500765431', 'avatar18.png', 'employer', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Мадина', 'Жусупова', 30, 'madina@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0770345671', 'avatar19.png', 'employer', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Азамат', 'Каныбеков', 28, 'azamat@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0700987651', 'avatar20.png', 'employer', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Салтанат', 'Карабаева', 26, 'saltanat@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0550123457', 'avatar21.png', 'employer', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Руслан', 'Исаков', 34, 'ruslan@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0500987650', 'avatar22.png', 'employer', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Айсулуу', 'Тилекова', 29, 'aisulu@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0700543211', 'avatar23.png', 'employer', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Евгений', 'Карамышев', 32, 'evgeniy@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0550765433', 'avatar24.png', 'employer', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Лейла', 'Алимова', 27, 'leila@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0770345672', 'avatar25.png', 'employer', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Арслан', 'Бакытов', 31, 'arslan@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0700123499', 'avatar26.png', 'employer', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Гульмира', 'Садырбаева', 24, 'gulmira@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0550654322', 'avatar27.png', 'employer', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Жоомарт', 'Усенов', 30, 'joomart@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0500765433', 'avatar28.png', 'employer', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Айпери', 'Бектемирова', 26, 'aiperi@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0770345673', 'avatar29.png', 'employer', true, (SELECT id FROM roles WHERE role_name = 'USER')),
       ('Бакыт', 'Маматкулов', 29, 'bakyt@ex.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', '0700987652', 'avatar30.png', 'employer', true, (SELECT id FROM roles WHERE role_name = 'USER'));

INSERT INTO categories (name, parent_id)
VALUES ('IT', null),
       ('HR', null),
       ('Web Design', null);

INSERT INTO contact_type (type)
VALUES ('email'),
       ('phone');

INSERT INTO resumes (applicant_id, name, category_id, salary, is_active, created_date, update_time)
VALUES (2, 'Frontend Developer', 1, 1100.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (3, 'Backend Developer', 1, 1300.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (4, 'Project Manager', 1, 1500.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (5, 'Business Analyst', 1, 1000.00, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (6, 'DevOps Engineer', 1, 1400.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (7, 'UI/UX Designer', 3, 950.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (8, 'Mobile Developer', 1, 1250.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (9, 'Data Scientist', 1, 1600.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (10, 'System Administrator', 2, 1000.00, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (11, 'Technical Writer', 1, 800.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (12, 'QA Automation Engineer', 1, 1150.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (13, 'Product Owner', 1, 1550.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (14, 'Support Engineer', 1, 900.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (15, 'Network Engineer', 1, 1050.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (16, 'Content Manager', 1, 700.00, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO vacancies (name, description, category_id, salary, exp_from, exp_to, is_active, author_id, created_date, updated_time)
VALUES ('Backend Developer', 'Spring Boot, PostgreSQL', 1, 1500.00, 2, 5, true, 17, CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
       ('HR Specialist', 'Подбор персонала, интервью', 2, 800.00, 1, 3, true, 18, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Python Developer', 'Django, PostgreSQL', 1, 1500.00, 2, 5, true, 19, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Swift Developer', 'IOS', 2, 800.00, 1, 3, true, 20, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Frontend Developer', 'React, JavaScript, CSS', 1, 1300.00, 1, 4, true, 21, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('QA Engineer', 'Тестирование ПО, автоматизация', 3, 900.00, 1, 3, true, 22, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Project Manager', 'Управление проектами, Agile', 1, 1600.00, 3, 6, true, 23, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('DevOps Engineer', 'CI/CD, Docker, Kubernetes', 1, 1700.00, 2, 5, true, 24, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Mobile Developer', 'Android, Kotlin, Java', 1, 1400.00, 2, 4, true, 25, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('UI/UX Designer', 'Прототипирование, Figma', 3, 1000.00, 1, 3, true, 26, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Data Analyst', 'SQL, Excel, Power BI', 1, 1100.00, 1, 3, true, 27, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('System Administrator', 'Сервера, сети, безопасность', 1, 1200.00, 3, 5, true, 28, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Technical Writer', 'Документация, инструкции', 1, 800.00, 0, 2, true, 29, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Product Owner', 'Управление продуктом, Scrum', 1, 1550.00, 3, 6, true, 30, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Support Engineer', 'Техническая поддержка', 1, 900.00, 1, 3, true, 31, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO contacts_info (type_id, resume_id, contact_value)
VALUES  (1, 1, 'ulan@ex.com'),
        (2, 1, '0500123456'),
        (1, 2, 'ulan@ex.com'),
        (2, 2, '0500234567'),
        (1, 3, 'alisher@ex.com'),
        (2, 3, '0550654321'),
        (1, 4, 'aigerim@ex.com'),
        (2, 4, '0770765432'),
        (1, 5, 'nurlan@ex.com'),
        (2, 5, '0550345678'),
        (1, 6, 'dinara@ex.com'),
        (2, 6, '0770987654'),
        (1, 7, 'aziz@ex.com'),
        (2, 7, '0700234567'),
        (1, 8, 'aidana@ex.com');

INSERT INTO education_info (resume_id, institution, program, start_date, end_date, degree)
VALUES (1, 'Manas University', 'Software Engineering', '2016-09-01', '2020-06-30', 'Bachelor'),
       (2, 'American University of Central Asia', 'Information Systems', '2014-09-01', '2018-06-30', 'Bachelor'),
       (3, 'Kyrgyz-Turkish Manas University', 'Project Management', '2013-09-01', '2017-06-30', 'Bachelor'),
       (4, 'Bishkek Humanities University', 'Business Analysis', '2012-09-01', '2016-06-30', 'Bachelor'),
       (5, 'International University of Kyrgyzstan', 'DevOps Engineering', '2015-09-01', '2019-06-30', 'Bachelor'),
       (6, 'Kyrgyz State Technical University', 'Design', '2016-09-01', '2020-06-30', 'Bachelor'),
       (7, 'Manas University', 'Mobile Development', '2014-09-01', '2018-06-30', 'Bachelor'),
       (8, 'Kyrgyz State University', 'Data Science', '2015-09-01', '2019-06-30', 'Master'),
       (9, 'International University of Kyrgyzstan', 'System Administration', '2013-09-01', '2017-06-30', 'Bachelor'),
       (10, 'American University of Central Asia', 'Technical Writing', '2016-09-01', '2020-06-30', 'Bachelor'),
       (11, 'Kyrgyz-Turkish Manas University', 'QA Automation', '2014-09-01', '2018-06-30', 'Bachelor'),
       (12, 'Bishkek Humanities University', 'Product Ownership', '2013-09-01', '2017-06-30', 'Bachelor'),
       (13, 'Kyrgyz State Technical University', 'Technical Support', '2015-09-01', '2019-06-30', 'Bachelor'),
       (14, 'Manas University', 'Network Engineering', '2012-09-01', '2016-06-30', 'Bachelor'),
       (15, 'Kyrgyz State University', 'Computer Science', '2015-09-01', '2019-06-30', 'Bachelor');

INSERT INTO work_experience_info (resume_id, years, company_name, position, responsibilities)
VALUES (1, 2, 'Tech Solutions', 'Junior Developer', 'Worked on Java backend development'),
       (2, 1, 'SoftPro', 'QA Tester', 'Manual testing and reporting bugs'),
       (3, 3, 'Innovatech', 'Frontend Developer', 'Developed UI components using React'),
       (4, 4, 'ProjectMasters', 'Project Manager', 'Managed software development projects'),
       (5, 2, 'BizAnalytica', 'Business Analyst', 'Gathered requirements and coordinated with stakeholders'),
       (6, 3, 'CloudOps', 'DevOps Engineer', 'Implemented CI/CD pipelines'),
       (7, 2, 'DesignPro', 'UI/UX Designer', 'Created wireframes and prototypes'),
       (8, 2, 'MobileApps', 'Mobile Developer', 'Developed Android applications'),
       (9, 4, 'DataSense', 'Data Scientist', 'Analyzed large datasets and created ML models'),
       (10, 3, 'NetSecure', 'System Administrator', 'Maintained servers and network infrastructure'),
       (11, 1, 'DocuTech', 'Technical Writer', 'Prepared user manuals and documentation'),
       (12, 2, 'QA Experts', 'QA Automation Engineer', 'Automated test scripts development'),
       (13, 3, 'ProdLead', 'Product Owner', 'Defined product backlog and priorities'),
       (14, 2, 'SupportX', 'Support Engineer', 'Provided technical support to clients'),
       (15, 3, 'NetWorks', 'Network Engineer', 'Managed corporate network infrastructure');

INSERT INTO responded_applicants (resume_id, vacancy_id, confirmation)
VALUES (1, 1, true),
       (2, 2, false),
       (3, 3, true),
       (4, 4, false),
       (5, 5, true),
       (6, 6, true),
       (7, 7, false),
       (8, 8, true),
       (9, 9, false),
       (10, 10, true),
       (11, 11, true),
       (12, 12, false),
       (13, 13, true),
       (14, 14, false),
       (15, 15, true);

INSERT INTO messages (responded_applicant_id, content, timestamp)
VALUES (1, 'Здравствуйте! Ваш отклик принят.', CURRENT_TIMESTAMP),
       (2, 'Спасибо за интерес к вакансии. Мы свяжемся с вами позже.', CURRENT_TIMESTAMP);

