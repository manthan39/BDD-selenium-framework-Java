import sys
sys.path.append('C:\Users\mvbhatiya\Desktop\Python_selenium')
from ui.basepage.page import Page 
import unittest
from selenium import webdriver
# from Page import *



from ui.locators.locators import registrationPageLocatars

# from RegistrationPage import *
from ui.pages.registration_page import RegistrationPage
from selenium.webdriver.common.by import By


# I am using python unittest for asserting cases.
# In this module, there should be test cases.
# If you want to run it, you should type: python <module-name.py>

class registrationTestPage(unittest.TestCase):
    
    @classmethod
    def setUpClass(self):
        # self.driver = webdriver.Chrome()
        self.driver = webdriver.Firefox();
        self.driver.get("http://www.way2automation.com/angularjs-protractor/registeration/#/login")
        
    def test_login(self):
        page = RegistrationPage(self.driver)    
        page.Enter_username("angular")
        page.Enter_password("password")
        page.Enter_mandtoryUserName("angular")
        page.click_on_LoginBtn()
        Loginsucess=page.VerifyLoginsucess()        
        print("Message is "+Loginsucess)
        self.assertIn("You're logged in!!",Loginsucess)
        

    def test_logout(self):
        page=RegistrationPage(self.driver)
        page.click_on_LogoutBtn()

    @classmethod
    def tearDownClass(self):
        self.driver.close()
# 
if __name__ == "__main__":
    suite = unittest.TestLoader().loadTestsFromTestCase(registrationTestPage)
    unittest.TextTestRunner(verbosity=2).run(suite)