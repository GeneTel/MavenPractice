
SELECT * FROM public."Homework";
--Get all records from Lesson including Homework data
SELECT 
    l.*, 
    h.name as homework_name, 
    h.description as homework_description 
FROM 
    public."Lesson" l
JOIN 
    public."Homework" h 
ON 
    l.homework_id = h.id;

-- Get all records from Lesson including Homework data sorted by updatedAt
SELECT 
    l.*, 
    h.name as homework_name, 
    h.description as homework_description 
FROM 
    public."Lesson" l
JOIN 
    public."Homework" h 
ON 
    l.homework_id = h.id
ORDER BY 
    l."updatedAt";

-- Get all records from Schedule including Lesson data
SELECT 
    s.*, 
    l.id as lesson_id, 
    l.name as lesson_name, 
    l."updatedAt" as lesson_updatedAt,
    l.homework_id 
FROM 
    public."Schedule" s
JOIN 
    public."Schedule_Lesson" sl 
ON 
    s.id = sl.schedule_id
JOIN 
    public."Lesson" l 
ON 
    sl.lesson_id = l.id;

-- Get the count of Lessons for each Schedule
SELECT 
    s.id, 
    s.name, 
    COUNT(sl.lesson_id) as lesson_count 
FROM 
    public."Schedule" s
JOIN 
    public."Schedule_Lesson" sl 
ON 
    s.id = sl.schedule_id
GROUP BY 
    s.id, s.name;
