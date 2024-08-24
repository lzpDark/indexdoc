#!/bin/bash

# -k: (TLS SFTP SCP) By default, every secure connection curl makes is verified to be secure before the transfer takes place.
#   This option makes curl skip the verification step and proceed without checking.
curl -XGET -k -u elastic:123456 https://localhost:9200