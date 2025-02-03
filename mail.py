import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
from email.utils import formataddr

def send_email():
    # Email details
    sender_email = "angelina@webknot.in"
    sender_name = "Angelina | Webknot"
    recipient_email = "shivsrivas101@gmail.com"
    subject = "Updated invitation: TR - 2 - Flutter Intern - Interview"

    # Create the email
    message = MIMEMultipart()
    message["From"] = formataddr((sender_name, sender_email))
    message["Reply-To"] = "angelina@webknot.in"
    message["To"] = recipient_email
    message["Subject"] = subject

    body = """
    This event has been updated:
    Changed: Title, Time

    Join with Google Meet:
    Meeting link: meet.google.com/fid-awok-iss
    Join by phone: (US) +1 929-276-1002 PIN: 455355207

    Flutter Intern:
    1. Building and shipping robust apps to Android/iOS devices using a single codebase (Flutter).
    2. Writing readable and clear code using Dart that will be extensively documented for future use and upgrades.
    3. Sharing feedback and brainstorming ideas with teams to improve the development process.

    When CHANGED:
    Wednesday 18 Dec 2024 ⋅ 10am – 11am (India Standard Time - Kolkata)
    """

    message.attach(MIMEText(body, "plain"))

    # Send the email
    try:
        smtp_server = "smtp.gmail.com"
        smtp_port = 587
        
        with smtplib.SMTP(smtp_server, smtp_port) as server:
            server.starttls()
            server.login("shivsrivas101@gmail.com", "nfyc mjzv couf uuhh")
            server.sendmail(sender_email, recipient_email, message.as_string())
            print("Email sent successfully!")
    except Exception as e:
        print(f"Error: {e}")

# Call the function
if __name__ == "__main__":
    send_email()