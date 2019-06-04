#!/bin/bash
set -euo pipefail

# Submit the App
spark2-submit \
--class com.tookitaki.rs.RecADriver \
--master yarn \
--deploy-mode cluster \
--conf "spark.driver.extraJavaOptions=-Dlog4j.configuration=file:log4j.properties" \
--files log4j.properties, config_recA.conf, recon_context_recA.conf \
--conf spark.dynamicAllocation.enabled=true \
RecA-assembly-0.1.jar config.conf recon_context_recA.conf &

echo "Script Successfully executed."
exit 0