// class Singletleton {
//     String instance;
//     public void Singleton() {
//         // instance = new Singleton();
//     }

//     public static Singleton initializeSingleton(){
//         if(instance != null){
//             instance = new Singleton();
//         }
//         return instance;
//     }
// }

// class Main {
//     public static void main(){
//         Singleton s = Singleton();
//         s.initializeSingleton();
//     }
// }

// // employee table [empId, empName, empSalary, Department, ManagerEmpId]

// select empname, max(salary) as second_max_salary from employee where salary < (select max(empSalary) from employee);

// JavaBackend ArchitectureAlgorithmNode.js Microservices ArchitectureAWSAPIRDBMS