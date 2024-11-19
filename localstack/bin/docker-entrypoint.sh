#!/bin/bash
echo "[INFO] - start"

aws sqs create-queue \
	--queue-name confirmation-payment-sqs.fifo \
	--endpoint-url=http://localhost:4566 \
	--attributes FifoQueue=true

echo "[INFO] - finish"