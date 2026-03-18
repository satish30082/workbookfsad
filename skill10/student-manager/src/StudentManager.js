import React, { useState } from "react";
import "./StudentManager.css";

function StudentManager() {
  const [students, setStudents] = useState([
    { id: 1, name: "Satish", course: "CSE" },
    { id: 2, name: "Ravi", course: "ECE" },
    { id: 3, name: "Anu", course: "IT" },
    { id: 4, name: "Kiran", course: "EEE" },
    { id: 5, name: "Meena", course: "CSE" }
  ]);

  const [newStudent, setNewStudent] = useState({
    id: "",
    name: "",
    course: ""
  });

  const handleChange = (e) => {
    setNewStudent({
      ...newStudent,
      [e.target.name]: e.target.value
    });
  };

  const addStudent = () => {
    if (!newStudent.id || !newStudent.name || !newStudent.course) return;

    setStudents([...students, newStudent]);
    setNewStudent({ id: "", name: "", course: "" });
  };

  const deleteStudent = (id) => {
    setStudents(students.filter((stu) => stu.id !== id));
  };

  return (
    <div className="container">
      <h2>Student Manager</h2>

      <input name="id" placeholder="ID" value={newStudent.id} onChange={handleChange} />
      <input name="name" placeholder="Name" value={newStudent.name} onChange={handleChange} />
      <input name="course" placeholder="Course" value={newStudent.course} onChange={handleChange} />
      
      <button onClick={addStudent}>Add Student</button>

      {students.length === 0 ? (
        <p>No students available</p>
      ) : (
        <ul>
          {students.map((stu) => (
            <li key={stu.id}>
              {stu.id} - {stu.name} - {stu.course}
              <button onClick={() => deleteStudent(stu.id)}>Delete</button>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default StudentManager;