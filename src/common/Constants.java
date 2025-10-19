package common;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

/**
 * Application-wide constants for INHA AIR
 * Centralizes all magic numbers, colors, fonts, and configuration values
 */
public class Constants {

    // Application Info
    public static final String APP_NAME = "INHA AIR";
    public static final String VERSION = "1.0.0";

    // Window Dimensions
    public static final int WINDOW_WIDTH = 1120;
    public static final int WINDOW_HEIGHT = 770;
    public static final Dimension WINDOW_SIZE = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);

    // Database Configuration
    public static final String DB_URL = "jdbc:sqlite:inhaair.db";
    public static final String DB_DRIVER = "org.sqlite.JDBC";

    // Colors
    public static final Color COLOR_PRIMARY = new Color(10, 90, 150);
    public static final Color COLOR_HYPERLINK = new Color(0, 102, 255);
    public static final Color COLOR_BACKGROUND = Color.WHITE;
    public static final Color COLOR_SUCCESS = new Color(46, 125, 50);
    public static final Color COLOR_ERROR = new Color(198, 40, 40);
    public static final Color COLOR_WARNING = new Color(255, 160, 0);

    // Fonts
    public static final String FONT_FAMILY = "NanumGothic";
    public static final Font FONT_SMALL = new Font(FONT_FAMILY, Font.PLAIN, 12);
    public static final Font FONT_REGULAR = new Font(FONT_FAMILY, Font.PLAIN, 15);
    public static final Font FONT_MEDIUM = new Font(FONT_FAMILY, Font.BOLD, 16);
    public static final Font FONT_LARGE = new Font(FONT_FAMILY, Font.BOLD, 20);
    public static final Font FONT_XLARGE = new Font(FONT_FAMILY, Font.BOLD, 25);
    public static final Font FONT_TITLE = new Font(FONT_FAMILY, Font.BOLD, 30);

    // Common Panel Sizes
    public static final Dimension LOGIN_PANEL_SIZE = new Dimension(400, 500);
    public static final Dimension BUTTON_SIZE = new Dimension(120, 40);
    public static final Dimension TEXTFIELD_SIZE = new Dimension(200, 30);

    // Messages
    public static final String MSG_DB_CONNECT_SUCCESS = "데이터베이스 연결 성공!";
    public static final String MSG_DB_CONNECT_FAIL = "데이터베이스 연결 실패";
    public static final String MSG_LOGIN_SUCCESS = "로그인 성공";
    public static final String MSG_LOGIN_FAIL = "아이디 또는 비밀번호가 올바르지 않습니다";
    public static final String MSG_SIGNUP_SUCCESS = "회원가입 성공";
    public static final String MSG_REQUIRED_FIELD = "필수 항목을 입력해주세요";

    // SQL Table Names
    public static final String TABLE_USER = "user";
    public static final String TABLE_AIRPORT = "airport";
    public static final String TABLE_AIRPLANE = "airplane";
    public static final String TABLE_AIR_SCHEDULE = "airSchedule";
    public static final String TABLE_SEAT = "seat";
    public static final String TABLE_RESERVATION = "reservation";
    public static final String TABLE_RESERVATION_DETAIL = "reservationDetail";
    public static final String TABLE_PAYMENT = "payment";
    public static final String VIEW_LOGIN = "login";

    // Validation
    public static final int MIN_PASSWORD_LENGTH = 4;
    public static final int MAX_PASSWORD_LENGTH = 20;
    public static final int MIN_ID_LENGTH = 3;
    public static final int MAX_ID_LENGTH = 20;

    private Constants() {
        // Prevent instantiation
        throw new AssertionError("Cannot instantiate Constants class");
    }
}
