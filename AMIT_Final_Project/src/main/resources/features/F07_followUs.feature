Feature:  users could open followUs links
  Scenario Outline: user opens facebook link
    Given open home page to followUs
    Then Click on <Icon Name> and the <Expected URL>
    Examples:
      | Icon Name |                           Expected URL                         |
      | facebook  |        https://www.facebook.com/nopCommerce                    |
      | twitter   |        https://twitter.com/nopCommerce                         |
      | rss       |        https://demo.nopcommerce.com/new-online-store-is-open   |
      | youtube   |        https://www.youtube.com/user/nopCommerce                |