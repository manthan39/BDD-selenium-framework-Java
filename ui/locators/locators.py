from selenium.webdriver.common.by import By

# for maintainability we can seperate web objects by page name

class registrationPageLocatars(object):
  usernamefield       = (By.XPATH, ".//*[@id='username']")
  passwordfield       = (By.XPATH, ".//*[@id='password']")
  username_mandatory  = (By.XPATH, "//div/div/input")
  loginBtn            = (By.XPATH, "//button")
  loggedinMsg         = (By.XPATH, "//p[1]")
  logoutBtn           = (By.CSS_SELECTOR, "a")




    
    
    









