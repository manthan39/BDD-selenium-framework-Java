from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import sys
sys.path.append('C:\Users\mvbhatiya\Desktop\Python_selenium')
from ui.basepage.page import Page
from ui.locators.locators import registrationPageLocatars
from selenium.webdriver.support.ui import WebDriverWait
import time


# Page opjects are written in this module.
# Depends on the page functionality we can have more functions for new classes

class RegistrationPage(Page):
    
    def Enter_username(self, username):
        self.find_element(*registrationPageLocatars.usernamefield).send_keys(username)

    def Enter_password(self, passwd):
        self.find_element(*registrationPageLocatars.passwordfield).send_keys(passwd)
        
        
        
    def Enter_mandtoryUserName(self, mandatory_username):
        self.find_element(*registrationPageLocatars.username_mandatory).send_keys(mandatory_username)
        

    def click_on_LoginBtn(self):
        self.find_element(*registrationPageLocatars.loginBtn).click()

    def VerifyLoginsucess(self):
        time.sleep(3)
        return self.find_element(*registrationPageLocatars.loggedinMsg).text

    def click_on_LogoutBtn(self):
        time.sleep(3)
        self.find_element(*registrationPageLocatars.logoutBtn).click()
