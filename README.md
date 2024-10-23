Tanaka Nhekairo
H230261H

# SecureCodMiniProject

**Presentation**
This project provides a secure sign-up and login page for users to create accounts and access a personalized dashboard. Upon successful login, users are greeted with their name and registration number. The application is designed with a user-friendly interface that ensures ease of navigation and accessibility.

1. Features:
->User-friendly sign-up and login pages

->Dashboard displaying user’s name and registration number

->Responsive design for mobile and desktop devices

3. Application of Secure Coding Principles
The application adheres to secure coding principles to protect user data and prevent vulnerabilities. Key practices include:

a. Input Validation: All user inputs are validated to prevent injection attacks.

b. Password Hashing: User passwords are hashed using a strong algorithm (e.g., bcrypt) before storage.

c. Error Handling: Errors are logged without exposing sensitive information to the user.

4. Implementing OWASP TOP 10

This project implements measures to mitigate risks outlined in the OWASP Top 10 vulnerabilities:

i. Injection: Prepared statements and parameterized queries are used to prevent SQL injection.

ii. Broken Authentication: Strong password policies and account lockout mechanisms are enforced.

iii. Sensitive Data Exposure: HTTPS is enforced, and sensitive data is encrypted both in transit and at rest.

iv. XML External Entities (XXE): XML parsing is configured to disable external entity processing.

v. Broken Access Control: Role-based access control is implemented to restrict access to certain features.

vi. Security Misconfiguration: Default configurations are reviewed and hardened.

vii. Cross-Site Scripting (XSS): User inputs are sanitized to prevent XSS attacks.

viii. Insecure Deserialization: Data serialization is handled securely to avoid code execution vulnerabilities.

ix. Using Components with Known Vulnerabilities: Regular updates and dependency checks are performed.

x. Insufficient Logging & Monitoring: Comprehensive logging and monitoring are in place to detect and respond to security incidents.

4. Unit Testing

Unit tests are implemented to ensure the reliability and security of the application. Key areas covered by tests include:

a. Input Validation: Tests to verify that invalid inputs are correctly rejected.

b. Authentication: Tests for successful and failed login attempts.

c. Password Hashing: Tests to ensure passwords are hashed and verified correctly.

Conclusion

This project aims to provide a secure, reliable, and user-friendly experience for users looking to manage their accounts effectively. 

By following secure coding principles and best practices, I ensure that user data is protected while delivering a seamless experience.

