# 🎓 Comprehensive Project Documentation
## React TypeScript + Spring Boot Full-Stack Application

---

## 📋 Table of Contents
1. [Project Overview](#project-overview)
2. [GitHub Codespaces Setup](#github-codespaces-setup)
3. [Running Frontend & Backend Services](#running-frontend--backend-services)
4. [High-Level System Architecture](#high-level-system-architecture)
5. [Frontend-Backend-Codespaces Interaction](#frontend-backend-codespaces-interaction)
6. [CRUD Workflow Explanation](#crud-workflow-explanation)
7. [Object-Oriented Principles Used](#object-oriented-principles-used)

---

## 📌 Project Overview

### What is This Project?

A **full-stack web application** for managing students and courses at United International University, demonstrating modern development practices:

- **Backend**: Spring Boot REST API (Java 17)
- **Frontend**: React + TypeScript + Vite (Modern UI)
- **DevOps**: GitHub Actions CI/CD Pipeline
- **Hosting**: Render (Backend) + Vercel (Frontend)

### Key Features

| Feature | Description |
|---------|-------------|
| **Student Management API** | CRUD operations for students with ID, name, email, CGPA |
| **Course Management API** | CRUD operations for courses with code, name, credits, instructor |
| **Full-Stack Integration** | React frontend displays data from Spring Boot backend |
| **Type Safety** | TypeScript on frontend, Java with Spring Boot on backend |
| **Automated Deployment** | GitHub Actions triggers builds and deploys to cloud |
| **Development Environment** | GitHub Codespaces with pre-configured tools |

### Real-World Architecture

```
┌──────────────────────────────────┐
│   User's Web Browser             │
│  (HTTPS connection)              │
└──────────────────────────────────┘
            ↓ ↑
    HTTP/REST API Calls
            ↓ ↑
┌──────────────────────────────────┐
│  React Frontend (Port 3000)      │
│  - App.tsx (Main Component)      │
│  - Fetch student/course data     │
│  - Display tables                │
│  - TypeScript for type safety    │
└──────────────────────────────────┘
            ↓ ↑
  Vite Proxy (Dev only)
   /api → localhost:8080
            ↓ ↑
┌──────────────────────────────────┐
│  Spring Boot Backend (Port 8080) │
│  - StudentController             │
│  - CourseController              │
│  - REST endpoints                │
│  - JSON responses                │
│  - CORS enabled                  │
└──────────────────────────────────┘
            ↓ ↑
     In-Memory Data Store
  (Static ArrayList collections)
```

---

## ☁️ GitHub Codespaces Setup

### What is GitHub Codespaces?

GitHub Codespaces provides a **cloud-based development environment** that includes:
- Pre-configured JDK 17, Maven, Node.js
- Docker container for isolation
- VS Code IDE in the browser
- Automatic port forwarding
- All dependencies pre-installed

### Step 1: Create Codespaces Instance

1. Go to your GitHub repository: **sdipu202095-cs/Aoop-Assignment-Main**
2. Click **Code** button
3. Click **Codespaces** tab
4. Click **Create codespace on main** (or **+ New with options** for 4-core machine)

```
Code
  ↓
Codespaces Tab
  ↓
"+ New with options"
  ↓
Select "4-core" machine type (recommended)
  ↓
Click "Create codespace"
```

### Step 2: Wait for Automatic Setup (2-3 minutes)

The `.devcontainer.json` configuration automatically:
- ✅ Downloads JDK 17
- ✅ Downloads Maven
- ✅ Downloads Node.js 18
- ✅ Builds backend with `mvn package`
- ✅ Installs frontend dependencies with `npm install`

**Console output will show:**
```
Setting up Java 17...
Setting up Maven...
Setting up Node.js...
Building backend...
Installing frontend dependencies...
Done! ✓
```

### Step 3: Verify Installation

Once Codespaces opens, open a terminal and verify:

```bash
# Check Java
java -version
# Output: openjdk version "17.0.x"

# Check Maven
mvn -version
# Output: Apache Maven 3.x.x

# Check Node.js
node -version
# Output: v18.x.x

# Check npm
npm -version
# Output: 9.x.x
```

### Step 4: Understand Port Forwarding

Codespaces automatically forwards ports:
- **Port 3000**: Frontend (React dev server)
- **Port 8080**: Backend (Spring Boot)

Access via the **Ports** tab in Codespaces.

---

## 🚀 Running Frontend & Backend Services

### Architecture Overview

```
┌─────────────────────────────────┐
│   GitHub Codespaces             │
│  (Cloud Development Environment) │
│                                 │
│  ┌───────────────┐              │
│  │ Terminal 1    │              │
│  │ Backend       │              │
│  │ Port 8080     │              │
│  └───────────────┘              │
│                                 │
│  ┌───────────────┐              │
│  │ Terminal 2    │              │
│  │ Frontend      │              │
│  │ Port 3000     │              │
│  └───────────────┘              │
│                                 │
└─────────────────────────────────┘
         ↓ ↑ (HTTP requests)
     Your Web Browser
```

### Terminal 1: Start Backend Server

```bash
# Navigate to backend directory
cd backend

# Run Spring Boot application
mvn spring-boot:run
```

**Expected Output:**
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v3.1.4)

2026-01-18 17:30:00.000 INFO  ... DemoApplication: Started DemoApplication in 4.567 seconds
```

**Backend is ready!** Test it:
```bash
curl http://localhost:8080/
# Returns: {"message":"Hello Advance OOP Lab Students"}

curl http://localhost:8080/api/students
# Returns: [{"id":"S001","name":"Alice Johnson",...}]

curl http://localhost:8080/api/courses
# Returns: [{"code":"CSE2118","name":"Advanced...",...}]
```

### Terminal 2: Start Frontend Server

**Open a new terminal in Codespaces:**

```bash
# Navigate to frontend directory
cd frontend

# Install dependencies (if not already done)
npm install

# Start Vite development server
npm run dev
```

**Expected Output:**
```
  VITE v5.4.21  ready in 234 ms

  ➜  Local:   http://localhost:3000/
  ➜  press h to show help
```

### Step 3: Access Application in Browser

1. In Codespaces, click **Ports** tab
2. Find **Port 3000** (Frontend)
3. Click the globe icon to open in browser
4. **You should see:**
   - Heading: "React + TypeScript + Spring Boot"
   - Message: "Backend says: Hello Advance OOP Lab Students"
   - Table of Students
   - Table of Courses

### Troubleshooting

| Issue | Solution |
|-------|----------|
| Backend won't start | Check if port 8080 is in use: `lsof -i :8080` |
| Frontend won't start | Check if port 3000 is in use: `lsof -i :3000` |
| Can't see students/courses | Ensure backend is running on 8080 first |
| CORS errors | Verify `CorsConfig.java` has `allowedOrigins("*")` |

---

## 🏗️ High-Level System Architecture

### 1. **Three-Tier Architecture**

```
┌─────────────────────────────────────────────────────┐
│                  PRESENTATION TIER                  │
│                  (React Frontend)                   │
│                                                     │
│  - User Interface (Tables, Forms)                   │
│  - TypeScript for type safety                       │
│  - useState for state management                    │
│  - useEffect for data fetching                      │
└─────────────────────────────────────────────────────┘
                        ↓ ↑
                 HTTP REST API
                 (JSON over HTTP)
                        ↓ ↑
┌─────────────────────────────────────────────────────┐
│                  APPLICATION TIER                   │
│              (Spring Boot Backend)                  │
│                                                     │
│  - @RestController → Handles HTTP requests          │
│  - @RequestMapping → Routes requests                │
│  - Dependency Injection → Loose coupling            │
│  - JSON Serialization → Auto via Jackson            │
└─────────────────────────────────────────────────────┘
                        ↓ ↑
                  Data Access
                        ↓ ↑
┌─────────────────────────────────────────────────────┐
│                   DATA TIER                         │
│          (In-Memory Data Store - ArrayList)         │
│                                                     │
│  - Student List (4 sample records)                  │
│  - Course List (4 sample records)                   │
│  - Future: Replace with Database                   │
└─────────────────────────────────────────────────────┘
```

### 2. **Component Breakdown**

#### Backend Components

```
com.example.demo
├── DemoApplication.java (@SpringBootApplication)
│   - Entry point
│   - Starts Spring IoC container
│   - Enables component scanning
│   - Auto-configures Tomcat
│
├── controller/
│   ├── HelloController.java
│   │   - GET / → Returns welcome message
│   │   - @RestController annotation
│   │   - Direct JSON response
│   │
│   ├── StudentController.java
│   │   - GET /api/students → Get all students
│   │   - GET /api/students/{id} → Get single student
│   │   - POST /api/students → Add new student
│   │   - PUT /api/students/{id} → Update student
│   │   - DELETE /api/students/{id} → Delete student
│   │
│   └── CourseController.java
│       - GET /api/courses → Get all courses
│       - GET /api/courses/{code} → Get single course
│       - POST /api/courses → Add new course
│       - PUT /api/courses/{code} → Update course
│       - DELETE /api/courses/{code} → Delete course
│
├── model/
│   ├── Student.java
│   │   - Properties: id, name, email, cgpa
│   │   - Getters/Setters (JavaBean pattern)
│   │   - toString() for debugging
│   │
│   └── Course.java
│       - Properties: code, name, credits, instructor
│       - Getters/Setters (JavaBean pattern)
│       - toString() for debugging
│
└── config/
    └── CorsConfig.java
        - @Configuration annotation
        - Implements WebMvcConfigurer
        - Enables CORS for all origins
        - Allows all HTTP methods
```

#### Frontend Components

```
App.tsx (Main Component)
├── State Management (useState)
│   ├── message: string (backend welcome message)
│   ├── students: Student[] (array of students)
│   ├── courses: Course[] (array of courses)
│   ├── loadingStudents: boolean (loading state)
│   └── loadingCourses: boolean (loading state)
│
├── Data Fetching (useEffect)
│   ├── Fetch /api (welcome message)
│   ├── Fetch /api/students (student list)
│   └── Fetch /api/courses (course list)
│
└── UI Rendering (JSX)
    ├── Welcome message section
    ├── Students table
    │   └── Columns: ID, Name, Email, CGPA
    └── Courses table
        └── Columns: Code, Name, Credits, Instructor
```

### 3. **Data Flow Diagram**

```
USER ACTION
    ↓
Component Renders (useEffect triggered on mount)
    ↓
fetch('/api/students') is called
    ↓
HTTP GET request sent to localhost:3000/api/students
    ↓
Vite proxy intercepts (config: rewrite /api → /api)
    ↓
Request forwarded to http://localhost:8080/api/students
    ↓
Spring Boot routes to StudentController.getAllStudents()
    ↓
Method returns List<Student> (static ArrayList)
    ↓
Spring converts to JSON [{"id":"S001",...}, ...]
    ↓
Response sent back to browser
    ↓
fetch().then() catches response
    ↓
setStudents(data) updates state
    ↓
Component re-renders with student data
    ↓
Table displays students in UI
```

---

## 🔄 Frontend-Backend-Codespaces Interaction

### Interaction Flow Diagram

```
┌──────────────────────┐
│  GitHub Codespaces   │
│   Cloud Container    │
│                      │
│  ┌────────────────┐  │
│  │ Backend        │  │
│  │ Spring Boot    │  │
│  │ Port: 8080     │  │
│  │                │  │
│  │ GET /api/*     │  │
│  │ POST /api/*    │  │
│  │ PUT /api/*     │  │
│  │ DELETE /api/*  │  │
│  └────────────────┘  │
│         ↑ ↓          │
│    Internal HTTP     │
│      (localhost)     │
│         ↑ ↓          │
│  ┌────────────────┐  │
│  │ Frontend       │  │
│  │ React/Vite     │  │
│  │ Port: 3000     │  │
│  │                │  │
│  │ Proxy Config:  │  │
│  │ /api → :8080   │  │
│  └────────────────┘  │
└──────────────────────┘
         ↑ ↓
    Port Forwarding
   (Codespaces magic)
         ↑ ↓
┌──────────────────────┐
│  Your Web Browser    │
│  localhost:3000      │
│                      │
│ (Actually connects   │
│  to Codespaces)      │
└──────────────────────┘
```

### Step-by-Step Interaction

#### 1. **Developer Starts Services**

```bash
# Terminal 1: Start Backend
cd backend
mvn spring-boot:run
→ Tomcat listens on localhost:8080

# Terminal 2: Start Frontend
cd frontend
npm run dev
→ Vite server listens on localhost:3000
```

#### 2. **Browser Opens App**

```
User opens: http://localhost:3000
↓
Codespaces port forwarding:
- Localhost:3000 in browser connects to
- Container port 3000 (Vite server)
↓
React App loads in browser
```

#### 3. **React Component Fetches Data**

```
useEffect(() => {
  fetch('/api/students')  // Browser makes request to http://localhost:3000/api/students
})

Vite proxy intercepts:
- Request URL: http://localhost:3000/api/students
- Proxy rule: /api → rewrite to /
- Forward to: http://localhost:8080/students
↓
Spring Boot receives: GET /students
↓
StudentController.getAllStudents() executes
↓
Returns JSON: [{"id":"S001",...}, ...]
↓
Back to browser via proxy
↓
React setState() updates UI
↓
Table renders with student data
```

#### 4. **Key Interactions Summary**

| Component | Port | Protocol | Role |
|-----------|------|----------|------|
| React Frontend | 3000 | HTTP | Displays UI, Makes requests |
| Vite Dev Server | 3000 | HTTP | Serves frontend, proxies /api |
| Spring Boot | 8080 | HTTP | Processes requests, returns JSON |
| Tomcat Server | 8080 | HTTP | Application server (embedded) |

---

## 📝 CRUD Workflow Explanation

### What is CRUD?

| Operation | HTTP Method | Example URL | Purpose |
|-----------|------------|-------------|---------|
| **C**reate | POST | `/api/students` | Add new record |
| **R**ead | GET | `/api/students/{id}` | Retrieve record(s) |
| **U**pdate | PUT | `/api/students/{id}` | Modify existing record |
| **D**elete | DELETE | `/api/students/{id}` | Remove record |

### Student CRUD Operations

#### 1. **CREATE - Add New Student**

**Frontend Code (App.tsx):**
```typescript
const newStudent = {
  id: "S005",
  name: "Eva Martinez",
  email: "eva@uiu.edu.bd",
  cgpa: 3.95
}

fetch('/api/students', {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify(newStudent)
})
.then(res => res.json())
.then(data => setStudents([...students, data]))
```

**Backend Code (StudentController.java):**
```java
@PostMapping
public Student addStudent(@RequestBody Student student) {
  students.add(student);  // Add to ArrayList
  return student;         // Return added student (HTTP 200)
}
```

**HTTP Flow:**
```
POST http://localhost:3000/api/students
Headers: Content-Type: application/json
Body: {"id":"S005","name":"Eva Martinez",...}
↓
Vite proxy forwards to http://localhost:8080/api/students
↓
Spring Boot routes to StudentController.addStudent()
↓
Student added to ArrayList
↓
Response: HTTP 200
Body: {"id":"S005","name":"Eva Martinez",...}
↓
Frontend updates state and re-renders table
```

#### 2. **READ - Get All Students**

**Frontend Code (App.tsx):**
```typescript
useEffect(() => {
  fetch('/api/students')
    .then(res => res.json())
    .then(data => {
      setStudents(data);
      setLoadingStudents(false);
    })
}, [])
```

**Backend Code (StudentController.java):**
```java
@GetMapping
public List<Student> getAllStudents() {
  return students;  // Return all students
}
```

**HTTP Flow:**
```
GET http://localhost:3000/api/students
↓
Vite proxy forwards to http://localhost:8080/api/students
↓
Spring Boot routes to StudentController.getAllStudents()
↓
Returns ArrayList<Student> with 4 records
↓
Spring converts to JSON array
↓
Response: HTTP 200
Body: [
  {"id":"S001","name":"Alice Johnson",...},
  {"id":"S002","name":"Bob Smith",...},
  {"id":"S003","name":"Carol White",...},
  {"id":"S004","name":"David Brown",...}
]
↓
Frontend displays in table
```

#### 3. **READ - Get Single Student**

**Frontend Code (App.tsx):**
```typescript
fetch('/api/students/S001')
  .then(res => res.json())
  .then(data => console.log(data))
```

**Backend Code (StudentController.java):**
```java
@GetMapping("/{id}")
public Student getStudent(@PathVariable String id) {
  Optional<Student> student = students.stream()
    .filter(s -> s.getId().equals(id))
    .findFirst();
  return student.orElse(null);
}
```

**HTTP Flow:**
```
GET http://localhost:3000/api/students/S001
↓
Spring filters ArrayList for matching ID
↓
Response: HTTP 200
Body: {"id":"S001","name":"Alice Johnson",...}
```

#### 4. **UPDATE - Modify Existing Student**

**Frontend Code (App.tsx):**
```typescript
const updatedStudent = {
  name: "Alice Johnson Updated",
  email: "alice.new@uiu.edu.bd",
  cgpa: 3.90
}

fetch('/api/students/S001', {
  method: 'PUT',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify(updatedStudent)
})
.then(res => res.json())
.then(data => {
  // Update state with updated student
})
```

**Backend Code (StudentController.java):**
```java
@PutMapping("/{id}")
public Student updateStudent(@PathVariable String id, 
                            @RequestBody Student updatedStudent) {
  Optional<Student> existingStudent = students.stream()
    .filter(s -> s.getId().equals(id))
    .findFirst();
  
  if (existingStudent.isPresent()) {
    Student student = existingStudent.get();
    student.setName(updatedStudent.getName());
    student.setEmail(updatedStudent.getEmail());
    student.setCgpa(updatedStudent.getCgpa());
    return student;
  }
  return null;
}
```

**HTTP Flow:**
```
PUT http://localhost:3000/api/students/S001
Headers: Content-Type: application/json
Body: {"name":"Alice Johnson Updated",...}
↓
Spring finds student with ID S001
↓
Updates properties from request body
↓
ArrayList updated (same object reference)
↓
Response: HTTP 200
Body: {"id":"S001","name":"Alice Johnson Updated",...}
```

#### 5. **DELETE - Remove Student**

**Frontend Code (App.tsx):**
```typescript
fetch('/api/students/S001', {
  method: 'DELETE'
})
.then(res => res.json())
.then(success => {
  if (success) {
    setStudents(students.filter(s => s.id !== 'S001'))
  }
})
```

**Backend Code (StudentController.java):**
```java
@DeleteMapping("/{id}")
public boolean deleteStudent(@PathVariable String id) {
  return students.removeIf(s -> s.getId().equals(id));
}
```

**HTTP Flow:**
```
DELETE http://localhost:3000/api/students/S001
↓
Spring removes student from ArrayList
↓
Response: HTTP 200
Body: true (deletion successful)
↓
Frontend removes student from UI table
```

### Course CRUD Workflow (Identical Pattern)

The `CourseController.java` follows the same CRUD pattern as `StudentController.java`:

```java
@GetMapping              // Read all
@GetMapping("/{code}")   // Read one
@PostMapping             // Create
@PutMapping("/{code}")   // Update
@DeleteMapping("/{code}")// Delete
```

### CRUD State Management Flow

```
User Interaction (Click button, Submit form)
    ↓
Frontend State Update
    ├─ Add: setItems([...items, newItem])
    ├─ Modify: setItems(items.map(...))
    └─ Remove: setItems(items.filter(...))
    ↓
HTTP Request Sent
    ├─ POST: Create new record
    ├─ GET: Fetch record(s)
    ├─ PUT: Update record
    └─ DELETE: Remove record
    ↓
Backend Processing
    ├─ Validate request
    ├─ Modify ArrayList in memory
    └─ Return response
    ↓
Frontend Response Handling
    └─ Update state if successful
    ↓
Component Re-renders
    ↓
User Sees Updated UI
```

---

## 🎯 Object-Oriented Principles Used

### 1. **Encapsulation**

Bundling data and methods, hiding internal implementation details.

#### Backend Example: Student Model

```java
public class Student {
    // Private data - hidden from outside access
    private String id;
    private String name;
    private String email;
    private double cgpa;

    // Public interface - controlled access
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    // ... more getters/setters
}
```

**Principle Applied:**
- Data members are `private`
- Access via public `getters` and `setters`
- Prevents direct manipulation
- Allows validation logic in setters (future)

#### Frontend Example: Component State

```typescript
function App() {
  // Private state - managed internally
  const [students, setStudents] = useState<Student[]>([])
  const [loadingStudents, setLoadingStudents] = useState(true)

  // State can only be modified via setState functions
  setStudents(newData)  // Controlled update
  
  return (
    <div>
      {/* UI renders based on encapsulated state */}
      {students.map(student => (...))}
    </div>
  )
}
```

**Principle Applied:**
- State is encapsulated within component
- Updates only via `setStudents()` function
- Prevents unintended modifications
- React manages state reactivity

---

### 2. **Inheritance & Polymorphism**

Spring Boot uses inheritance internally; our controllers could inherit from a base class.

#### Backend Concept: Controller Inheritance

```java
// Base controller (could be created)
public abstract class BaseController {
  protected List<Object> items = new ArrayList<>();
  
  public List<Object> getAll() {
    return items;
  }
}

// Specialized controller inherits from base
public class StudentController extends BaseController {
  @GetMapping
  public List<Student> getAllStudents() {
    return (List<Student>) items;  // Uses inherited method
  }
}

public class CourseController extends BaseController {
  @GetMapping
  public List<Course> getAllCourses() {
    return (List<Course>) items;  // Same inherited behavior
  }
}
```

**Principle Applied:**
- Code reuse through inheritance
- Polymorphic behavior (different classes, same method)
- Reduces code duplication

#### Spring Framework Polymorphism

```java
// Spring uses polymorphism internally
public interface WebMvcConfigurer {
  void addCorsMappings(CorsRegistry registry);
}

// Our class implements the interface
@Configuration
public class CorsConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    // Implementation
    registry.addMapping("/**").allowedOrigins("*");
  }
}

// Spring calls via interface reference (polymorphism)
WebMvcConfigurer configurer = new CorsConfig();
configurer.addCorsMappings(registry);  // Calls our implementation
```

**Principle Applied:**
- Implementation of interface contract
- Spring uses polymorphism to call our code
- Multiple implementations possible

---

### 3. **Abstraction**

Hiding complex implementation details behind simple interfaces.

#### Backend Example: REST Controller Abstraction

```java
@RestController
@RequestMapping("/api/students")
public class StudentController {
  // Complex internal logic hidden
  private static final List<Student> students = new ArrayList<>();
  
  // Simple public interface
  @GetMapping
  public List<Student> getAllStudents() {
    // Internal: filters, validation, etc.
    return students;
  }

  @PostMapping
  public Student addStudent(@RequestBody Student student) {
    // Internal: validation, duplicate checks, etc.
    students.add(student);
    return student;
  }
}
```

**Principle Applied:**
- Users see simple endpoints (`/api/students`)
- Complex logic hidden inside methods
- Implementation can change without affecting callers

#### Frontend Example: Component Abstraction

```typescript
function App() {
  // Complex state management and logic hidden
  const [students, setStudents] = useState<Student[]>([])
  const [loadingStudents, setLoadingStudents] = useState(true)

  useEffect(() => {
    // Complex fetch logic
    fetch('/api/students')
      .then(res => res.json())
      .then(data => {
        setStudents(data)
        setLoadingStudents(false)
      })
  }, [])

  // Simple UI interface - users see just the table
  return (
    <table>
      {students.map(student => (
        <tr key={student.id}>
          <td>{student.name}</td>
          <td>{student.email}</td>
        </tr>
      ))}
    </table>
  )
}
```

**Principle Applied:**
- Users see clean UI
- Data fetching logic abstracted
- Complexity hidden from consumers

---

### 4. **Composition**

Building complex objects from simpler objects.

#### Backend Example: Model Composition

```java
// Simple models
public class Student {
  private String id;
  private String name;
  private String email;
  private double cgpa;
}

public class Course {
  private String code;
  private String name;
  private int credits;
}

// Composite: Student taking a Course
public class Enrollment {
  private Student student;      // Composition
  private Course course;        // Composition
  private String semester;
  private String grade;
}
```

#### Frontend Example: Component Composition

```typescript
// Simple components
function StudentRow({ student }: { student: Student }) {
  return (
    <tr>
      <td>{student.name}</td>
      <td>{student.email}</td>
    </tr>
  )
}

// Composite component
function StudentTable({ students }: { students: Student[] }) {
  return (
    <table>
      <tbody>
        {students.map(student => (
          <StudentRow key={student.id} student={student} />
        ))}
      </tbody>
    </table>
  )
}

// Used in App
function App() {
  return <StudentTable students={students} />
}
```

**Principle Applied:**
- Small, focused components
- Composed into larger UI
- Reusable and maintainable

---

### 5. **Single Responsibility Principle (SRP)**

Each class should have one reason to change.

#### Backend: SRP Example

```java
// ❌ Bad: Controller doing too much
@RestController
public class StudentController {
  @GetMapping("/students")
  public List<Student> getStudents() {
    // Fetching from DB
    // Filtering
    // Validation
    // Logging
    // Too many responsibilities!
  }
}

// ✅ Good: Separation of concerns
@RestController
@RequestMapping("/api/students")
public class StudentController {
  @Autowired
  private StudentService service;

  @GetMapping
  public List<Student> getAllStudents() {
    return service.getAll();  // Delegates to service
  }
}

@Service
public class StudentService {
  // Business logic here
  public List<Student> getAll() { ... }
  public Student add(Student student) { ... }
}

@Repository
public class StudentRepository {
  // Data access here
  public List<Student> findAll() { ... }
}
```

**Current Project:** StudentController directly handles CRUD. Future enhancement would separate concerns into Service and Repository layers.

#### Frontend: SRP Example

```typescript
// ❌ Bad: Component doing too much
function App() {
  const [students, setStudents] = useState([])
  
  // Fetching data
  useEffect(() => {
    fetch('/api/students')...
  }, [])

  // Rendering table
  // Rendering forms
  // Handling clicks
  // Too many responsibilities!
}

// ✅ Good: Separation of concerns
function App() {
  const [students, setStudents] = useState([])
  
  // Fetch data
  useEffect(() => {
    fetch('/api/students').then(...)
  }, [])

  // Render
  return (
    <div>
      <StudentTable students={students} />
      <StudentForm onAdd={addStudent} />
    </div>
  )
}

function StudentTable({ students }) {
  // Only responsible for displaying table
  return <table>{...}</table>
}

function StudentForm({ onAdd }) {
  // Only responsible for form input
  return <form onSubmit={...}></form>
}
```

**Current Project:** App.tsx handles all concerns. Future refactor would separate StudentTable and CourseTable into own components.

---

### 6. **Dependency Injection (DI)**

Providing dependencies from outside rather than creating them inside.

#### Backend: Spring's Dependency Injection

```java
// ❌ Bad: Tightly coupled
@RestController
public class StudentController {
  private StudentService service = new StudentService();  // Hard-coded dependency
}

// ✅ Good: Injected dependency (Spring manages it)
@RestController
public class StudentController {
  @Autowired
  private StudentService service;  // Spring provides instance
}

@Service
public class StudentService {
  @Autowired
  private StudentRepository repository;  // Spring provides instance
}
```

**Principle Applied:**
- Spring creates and manages beans
- Loose coupling between classes
- Easy to test (mock dependencies)
- Easy to swap implementations

**In Our Current Project:**
```java
public class CorsConfig implements WebMvcConfigurer {
  // Spring automatically calls this method
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    // Registry is injected by Spring
    registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("*");
  }
}
```

---

### 7. **Polymorphism through Interfaces**

Different implementations of the same contract.

#### Backend: Interface-based Design

```java
// Interface defines contract
public interface UserRepository {
  List<User> findAll();
  User findById(String id);
  void save(User user);
}

// Multiple implementations
public class DatabaseUserRepository implements UserRepository {
  public List<User> findAll() {
    // Fetch from database
  }
}

public class InMemoryUserRepository implements UserRepository {
  public List<User> findAll() {
    // Fetch from ArrayList (current project)
  }
}

// Controller uses interface, not concrete class
@RestController
public class UserController {
  @Autowired
  private UserRepository repository;  // Works with any implementation!

  @GetMapping
  public List<User> getAll() {
    return repository.findAll();  // Polymorphic call
  }
}
```

**Current Project:** Controllers directly manage ArrayLists. Future enhancement would introduce Repository pattern.

---

### Summary of OOP Principles in Project

| Principle | Location | Example |
|-----------|----------|---------|
| **Encapsulation** | Student.java, Course.java | Private fields, public getters/setters |
| **Abstraction** | StudentController.java | Hides CRUD logic behind REST endpoints |
| **Inheritance** | CorsConfig extends WebMvcConfigurer | Implements Spring's interface |
| **Polymorphism** | Spring annotations | Multiple controllers follow same pattern |
| **Composition** | App.tsx rendering StudentTable | Components composed together |
| **SRP** | Could be improved | Controllers currently handle all logic |
| **DI** | Spring @Autowired | Spring provides dependencies |
| **Interface-based** | WebMvcConfigurer | Implementation contract |

---

## 🔗 How It All Comes Together

```
GITHUB CODESPACES (Cloud Development Environment)
│
├─ Terminal 1: Backend Server
│  └─ mvn spring-boot:run
│     └─ Starts Spring Boot on port 8080
│        ├─ DemoApplication.java creates IoC container
│        ├─ Component scanning finds controllers
│        ├─ CorsConfig enables cross-origin requests
│        ├─ StudentController listens on /api/students
│        └─ CourseController listens on /api/courses
│
├─ Terminal 2: Frontend Server
│  └─ npm run dev
│     └─ Starts Vite on port 3000
│        ├─ Serves React app
│        ├─ Vite proxy configured: /api → localhost:8080
│        └─ Hot Module Replacement (HMR) enabled
│
└─ Your Browser
   └─ Visits http://localhost:3000
      ├─ React App loads
      ├─ useEffect hooks fire
      ├─ fetch('/api/students') calls backend
      ├─ Vite proxy forwards to :8080
      ├─ StudentController returns JSON
      ├─ Frontend displays tables
      └─ User sees: Students & Courses!
```

---

## 📚 Next Steps & Learning Path

1. **Understand Spring Boot** → Read tutorials on Spring Boot
2. **Learn TypeScript** → Type safety in frontend
3. **Master React Hooks** → useState, useEffect, useContext
4. **Add Database** → Replace ArrayList with Spring Data JPA + MySQL
5. **Add Validation** → Input validation in models and controllers
6. **Add Error Handling** → Global exception handlers
7. **Write Tests** → Unit tests and integration tests
8. **Deploy to Cloud** → Use GitHub Actions to auto-deploy
9. **Add Authentication** → JWT tokens for security
10. **Build Real Features** → Grades, enrollment, schedules, etc.

---

**Happy Learning! 🚀**

*CSE 2118 - Advanced OOP Laboratory*  
*United International University*
