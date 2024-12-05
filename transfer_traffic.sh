#!/bin/bash

# Check if the correct number of arguments is provided
if [ "$#" -ne 2 ]; then
  echo "Usage: $0 <percentage> <additional_variable>"
  exit 1
fi

# Assign arguments to variables
PERCENTAGE=$1
ADDITIONAL_VARIABLE=$2

# Print a message indicating the traffic transfer
echo "Transferring ${PERCENTAGE}% of traffic with additional variable: ${ADDITIONAL_VARIABLE}"

# Add your traffic transfer logic here
# For example, you might call an API or run a command to adjust traffic routing

# Print a message indicating the traffic transfer is complete
echo "Traffic transfer of ${PERCENTAGE}% completed"