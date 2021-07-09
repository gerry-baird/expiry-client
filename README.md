# Expiry Client

This is a simple spring boot app that uses the Spring RestTemplate to call an ODM service that calculates dates.

There are three properties you'll need to be aware of in application.properties :

```
expirydate.apihost=https://odm-prod-release-odm-ds-runtime-route-odm.apps.k6w8mqhd.uksouth.aroapp.io
expirydate.username=user
expirydate.password=password
```

The values shown above for apihost points to an ODM server but the values for username and password are not correct for that host, these are secret and if you need them just ask me.

The code supresses SSL warnings as the server cert is self signed.