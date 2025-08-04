# Twilio Setup Guide

## Prerequisites
1. Create a free Twilio account at [https://www.twilio.com/try-twilio](https://www.twilio.com/try-twilio)
2. Get your Account SID and Auth Token from the Twilio Console
3. Get a Twilio phone number (free trial includes one)

## Configuration

### Option 1: Environment Variables (Recommended)
Set these environment variables:
```bash
export TWILIO_ACCOUNT_SID=your_account_sid_here
export TWILIO_AUTH_TOKEN=your_auth_token_here
export TWILIO_PHONE_NUMBER=+1234567890
```

### Option 2: Direct Configuration
Update `src/main/resources/application.yml`:
```yaml
twilio:
  account:
    sid: your_account_sid_here
  auth:
    token: your_auth_token_here
  phone:
    number: +1234567890
```

## API Usage

### Send Notification
```bash
curl -X POST http://localhost:8081/api/v1/notification/send \
  -H "Content-Type: application/json" \
  -d '{
    "pin": "1234",
    "message": "Hello from your app!",
    "phoneNumber": "+1234567890"
  }'
```

### Response Format
```json
{
  "message": "Message sent successfully with SID: SM...",
  "status": "SUCCESS",
  "timestamp": "2024-01-01T12:00:00"
}
```

## Notes
- Free trial includes $15 credit
- Phone numbers must be in international format (+1234567890)
- For testing, you can use your own phone number 