-- Create the database (if it doesn't already exist)
CREATE DATABASE IF NOT EXISTS Student_Management_System;

-- Use the database
USE Student_Management_System;

-- Create the Students table
CREATE TABLE Students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    date_of_birth DATE,
    gender ENUM('Male', 'Female'),
    phone_number VARCHAR(15),
    email VARCHAR(100),
    address TEXT
);

-- Create the Instructors table (if needed)
CREATE TABLE Instructors (
    instructor_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    phone_number VARCHAR(15),
    email VARCHAR(100)
);

-- Create the Courses table
CREATE TABLE Courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100),
    course_description TEXT,
    credits INT,
    instructor_id INT, -- You may want to link this to an instructor table
    FOREIGN KEY (instructor_id) REFERENCES Instructors(instructor_id)
);

-- Create the Enrollments table
CREATE TABLE Enrollments (
    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id INT,
    enrollment_date DATE,
    grade DECIMAL(4, 2), -- Assuming a decimal grade, you can modify the data type
    FOREIGN KEY (student_id) REFERENCES Students(student_id),
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);

-- Create the User table (if needed)
CREATE TABLE User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(255), -- Store hashed passwords securely
    role ENUM('admin', 'teacher', 'student', 'library staff')
);

-- Create the Attendance table (if needed)
CREATE TABLE Attendance (
    attendance_id INT AUTO_INCREMENT PRIMARY KEY,
    enrollment_id INT,
    date DATE,
    status ENUM('Present', 'Absent'),
    FOREIGN KEY (enrollment_id) REFERENCES Enrollments(enrollment_id)
);


/*
-- Create the Payments table (if needed)
CREATE TABLE Payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    amount DECIMAL(10, 2), -- You can adjust the precision and scale as needed
    payment_date DATE,
    payment_method VARCHAR(50),
    FOREIGN KEY (student_id) REFERENCES Students(student_id)
);
*/


