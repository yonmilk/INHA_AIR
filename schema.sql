-- INHA AIR SQLite Database Schema

-- User table
CREATE TABLE IF NOT EXISTS user (
    ID VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100),
    nameKOR VARCHAR(50),
    nameENG VARCHAR(100),
    sex VARCHAR(10),
    passport VARCHAR(50),
    birth DATE,
    tel VARCHAR(20),
    email VARCHAR(100),
    newsletter INTEGER DEFAULT 0,
    promotion INTEGER DEFAULT 0,
    sms INTEGER DEFAULT 0
);

-- Airport table
CREATE TABLE IF NOT EXISTS airport (
    code VARCHAR(10) PRIMARY KEY,
    continent VARCHAR(50),
    country VARCHAR(50),
    city VARCHAR(50),
    airportName VARCHAR(100),
    terminal VARCHAR(20),
    tel VARCHAR(20),
    email VARCHAR(100)
);

-- Airplane table
CREATE TABLE IF NOT EXISTS airplane (
    flightCode VARCHAR(20) PRIMARY KEY,
    `from` VARCHAR(10),
    `to` VARCHAR(10),
    economy INTEGER,
    business INTEGER,
    first INTEGER,
    economyPay DECIMAL(10,2),
    businessPay DECIMAL(10,2),
    firstPay DECIMAL(10,2),
    FOREIGN KEY (`from`) REFERENCES airport(code),
    FOREIGN KEY (`to`) REFERENCES airport(code)
);

-- Air Schedule table
CREATE TABLE IF NOT EXISTS airSchedule (
    scheduleNo INTEGER PRIMARY KEY AUTOINCREMENT,
    flightCode VARCHAR(20),
    `from` VARCHAR(10),
    fromDate DATE,
    fromTime TIME,
    `to` VARCHAR(10),
    toDate DATE,
    toTime TIME,
    FOREIGN KEY (flightCode) REFERENCES airplane(flightCode),
    FOREIGN KEY (`from`) REFERENCES airport(code),
    FOREIGN KEY (`to`) REFERENCES airport(code)
);

-- Seat table
CREATE TABLE IF NOT EXISTS seat (
    scheduleNo INTEGER,
    economy INTEGER,
    business INTEGER,
    first INTEGER,
    FOREIGN KEY (scheduleNo) REFERENCES airSchedule(scheduleNo)
);

-- Reservation table
CREATE TABLE IF NOT EXISTS reservation (
    reserveNum VARCHAR(50) PRIMARY KEY,
    ID VARCHAR(50),
    GOscheduleNo INTEGER,
    COMscheduleNo INTEGER,
    GOclass VARCHAR(20),
    COMclass VARCHAR(20),
    pay DECIMAL(10,2),
    reserveDate DATETIME,
    FOREIGN KEY (ID) REFERENCES user(ID),
    FOREIGN KEY (GOscheduleNo) REFERENCES airSchedule(scheduleNo),
    FOREIGN KEY (COMscheduleNo) REFERENCES airSchedule(scheduleNo)
);

-- Reservation Detail table
CREATE TABLE IF NOT EXISTS reservationDetail (
    detailNo INTEGER PRIMARY KEY AUTOINCREMENT,
    reserveNum VARCHAR(50),
    nameKOR VARCHAR(50),
    nameENG VARCHAR(100),
    passport VARCHAR(50),
    birth DATE,
    sex VARCHAR(10),
    FOREIGN KEY (reserveNum) REFERENCES reservation(reserveNum)
);

-- Payment table
CREATE TABLE IF NOT EXISTS payment (
    paymentNo INTEGER PRIMARY KEY AUTOINCREMENT,
    reserveNum VARCHAR(50),
    `date` DATETIME,
    payable VARCHAR(50),
    pay DECIMAL(10,2),
    FOREIGN KEY (reserveNum) REFERENCES reservation(reserveNum)
);

-- Login view (ID and password from user table)
DROP VIEW IF EXISTS login;
CREATE VIEW login AS
SELECT ID, password FROM user;

-- Insert sample admin user
INSERT OR IGNORE INTO user (ID, password, nameKOR, nameENG, sex, passport, birth, tel, email)
VALUES ('admin', 'admin123', '관리자', 'Administrator', '남', 'M12345678', '1990-01-01', '010-0000-0000', 'admin@inhaair.com');

-- Insert sample airports
INSERT OR IGNORE INTO airport (code, continent, country, city, airportName, terminal, tel, email)
VALUES
('ICN', '아시아', '대한민국', '인천', '인천국제공항', '국제', '1577-2600', 'info@airport.kr'),
('GMP', '아시아', '대한민국', '서울', '김포국제공항', '국내', '02-2660-2114', 'info@airport.kr'),
('PUS', '아시아', '대한민국', '부산', '김해국제공항', '국내', '051-974-2800', 'info@airport.kr'),
('CJU', '아시아', '대한민국', '제주', '제주국제공항', '국내', '064-797-2114', 'info@airport.kr'),
('NRT', '아시아', '일본', '도쿄', '나리타국제공항', '국제', '+81-476-34-8000', 'info@narita.jp'),
('HND', '아시아', '일본', '도쿄', '하네다공항', '국제', '+81-3-5757-8111', 'info@haneda.jp');
