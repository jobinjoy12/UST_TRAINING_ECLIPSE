JAVA 8 DATE/TIME CHEAT SHEET
=========================================

1. CREATING OBJECTS
-----------------------------------------
// Current Date/Time
LocalDate date = LocalDate.now();
LocalTime time = LocalTime.now();
LocalDateTime dateTime = LocalDateTime.now();

// Specific Date/Time
// Note: Month is 1-12 (Jan is 1)
LocalDate date = LocalDate.of(2025, 11, 28); 
LocalTime time = LocalTime.of(13, 30); // 1:30 PM


2. FORMATTING & PARSING (String <-> Date)
-----------------------------------------
// Key Pattern Letters (Case Sensitive!)
// yyyy = Year
// MM   = Month
// dd   = Day
// HH   = Hour (0-23)
// mm   = Minute

// String -> Date (Parsing)
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
String input = "27/11/2025";
LocalDate d = LocalDate.parse(input, fmt);

// Date -> String (Formatting)
String output = d.format(fmt);


3. DATE MATH (Adding/Subtracting)
-----------------------------------------
// WARNING: Dates are IMMUTABLE.
// You must save the result back to a variable!

// Wrong:
date.plusDays(5); // Result is lost

// Right:
date = date.plusDays(5); 

// Common Methods:
date = date.plusWeeks(1);
date = date.minusMonths(2);
date = date.withYear(2030); // Changes just the year


4. CALCULATING DIFFERENCES
-----------------------------------------
LocalDate d1 = LocalDate.of(2025, 1, 1);
LocalDate d2 = LocalDate.of(2025, 1, 10);

// Period: For Calendar Dates (Years, Months, Days)
Period p = Period.between(d1, d2);
int days = p.getDays(); // Returns 9

// Duration: For Time (Hours, Minutes, Seconds)
LocalTime t1 = LocalTime.of(10, 0);
LocalTime t2 = LocalTime.of(12, 30);
Duration d = Duration.between(t1, t2);

// ChronoUnit: For Total Counts (e.g., Total days between dates)
long totalDays = ChronoUnit.DAYS.between(d1, d2);


5. COMPARISONS (Boolean checks)
-----------------------------------------
boolean result;
result = date1.isBefore(date2);
result = date1.isAfter(date2);
result = date1.isEqual(date2);


6. TIME ZONES (ZonedDateTime)
-----------------------------------------
// 1. Get current time in specific zone
ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));

// 2. Convert to another zone (same instant, different clock time)
ZonedDateTime nyTime = zdt.withZoneSameInstant(ZoneId.of("America/New_York"));