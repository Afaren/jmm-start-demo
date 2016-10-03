#########################################################################
# File Name: db-initial.sh
# Author: Afar
# mail: 550047450@qq.com
# Created Time: Monday, October 03, 2016 PM02:42:25 CST
#########################################################################
#!/bin/bash

# connect to mysql as root user of mysql and execute sql script
mysql -u root -p < database/data_initial.sql
